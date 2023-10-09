package me.khajiitos.potionvapes.common.blockentity;

import me.khajiitos.potionvapes.common.item.VapeJuiceItem;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEventPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class VapeJuicerBlockEntity extends BlockEntity implements Container {
    protected NonNullList<ItemStack> items;
    protected int progress;
    public static final int MAX_PROGRESS = 100;

    public VapeJuicerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VapeBlockEntities.VAPE_JUICER, blockPos, blockState);
        this.items = NonNullList.withSize(3, ItemStack.EMPTY);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        tag.putInt("Progress", this.progress);
        ContainerHelper.loadAllItems(tag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        this.progress = tag.getInt("Progress");
        ContainerHelper.saveAllItems(tag, this.items);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return null;
    }

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, VapeJuicerBlockEntity blockEntity) {
        ItemStack itemFirst = blockEntity.items.get(0);
        ItemStack itemSecond = blockEntity.items.get(1);

        boolean updated = false;

        ItemStack result;
        if (itemFirst.getItem() instanceof VapeJuiceItem vapeJuiceItem && itemSecond.getItem() instanceof PotionItem) {
            result = itemFirst.copy();
            vapeJuiceItem.setVapeJuicePotionOf(result, itemSecond);
            vapeJuiceItem.setVapeJuiceLeft(result, 1.f);
        } else {
            result = null;
        }

        if (result != null) {
            blockEntity.progress++;

            if (blockEntity.progress >= MAX_PROGRESS) {
                blockEntity.progress = 0;
                blockEntity.items.set(2, result);
            }

            updated = true;
        } else {
            if (blockEntity.progress != 0) {
                blockEntity.progress = 0;
                updated = true;
            }
        }

        if (updated) {
            blockEntity.setChanged();
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
    public ItemStack getItem(int i) {
        return items.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int amount) {
        ItemStack itemStack = items.get(i);
        items.get(i).shrink(amount);
        return itemStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        items.set(i, ItemStack.EMPTY);
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        items.set(i, itemStack);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        items.clear();
    }
}
