package me.khajiitos.potionvapes.common.blockentity;

import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.item.VapeJuiceItem;
import me.khajiitos.potionvapes.common.menu.VapeJuicerMenu;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VapeJuicerBlockEntity extends BlockEntity implements Container, MenuProvider {
    protected NonNullList<ItemStack> items;
    protected int progress;
    public static final int MAX_PROGRESS = 100;

    public VapeJuicerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VapeBlockEntities.VAPE_JUICER, blockPos, blockState);
        this.items = NonNullList.withSize(3, ItemStack.EMPTY);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        this.progress = tag.getInt("Progress");
        ContainerHelper.loadAllItems(tag, this.items);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Progress", this.progress);
        ContainerHelper.saveAllItems(tag, this.items);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, VapeJuicerBlockEntity blockEntity) {
        ItemStack itemFirst = blockEntity.items.get(0);
        ItemStack itemSecond = blockEntity.items.get(1);

        boolean updated = false;

        ItemStack result;
        if (itemFirst.getItem() instanceof VapeJuiceItem vapeJuiceItem && itemSecond.getItem() instanceof PotionItem && vapeJuiceItem.getVapeJuiceLeft(itemFirst) <= 0.f && !PotionUtils.getPotion(itemSecond).hasInstantEffects()) {
            result = itemFirst.copy();
            vapeJuiceItem.setVapeJuicePotionOf(result, itemSecond);
            vapeJuiceItem.setVapeJuiceLeft(result, 1.f);
        } else if (itemFirst.getItem() instanceof IVapeDevice vapeDevice && itemSecond.getItem() instanceof VapeJuiceItem vapeJuiceItem && vapeDevice.canReplaceJuice()) {
            result = itemFirst.copy();
            vapeDevice.setVapeJuicePotion(result, vapeJuiceItem.getVapeJuicePotion(itemSecond));
            vapeDevice.setVapeJuiceLeft(result, vapeJuiceItem.getVapeJuiceLeft(itemSecond));
        } else {
            result = null;
        }

        if (result != null && blockEntity.items.get(2).isEmpty()) {
            blockEntity.progress++;

            if (blockEntity.progress > MAX_PROGRESS) {
                blockEntity.progress = 0;

                blockEntity.items.set(2, result);
                blockEntity.items.get(0).shrink(1);
                blockEntity.items.get(1).shrink(1);
            }

            updated = true;
        } else {
            if (blockEntity.progress != 0) {
                blockEntity.progress = 0;
                updated = true;
            }
        }

        if (updated) {
            blockEntity.markUpdated();
        }
    }

    public void markUpdated() {
        if (this.getLevel() != null) {
            this.setChanged();
            this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        }
    }

    public int getProgress() {
        return this.progress;
    }

    @Override
    public int getContainerSize() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public @NotNull ItemStack getItem(int i) {
        return items.get(i);
    }

    @Override
    public @NotNull ItemStack removeItem(int i, int amount) {
        ItemStack itemStack = items.get(i);
        ItemStack copy = itemStack.copy();
        copy.shrink(amount);
        items.set(i, copy);
        return itemStack;
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int i) {
        items.set(i, ItemStack.EMPTY);
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int i, @NotNull ItemStack itemStack) {
        items.set(i, itemStack);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        if (this.level == null || this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double)this.worldPosition.getX() + 0.5, (double)this.worldPosition.getY() + 0.5, (double)this.worldPosition.getZ() + 0.5) <= 64.0;
        }
    }

    @Override
    public void clearContent() {
        items.clear();
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("potionvapes.container.vape_juicer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
        return new VapeJuicerMenu(i, inventory, this.level == null ? ContainerLevelAccess.NULL : ContainerLevelAccess.create(this.level, this.getBlockPos()));
    }
}
