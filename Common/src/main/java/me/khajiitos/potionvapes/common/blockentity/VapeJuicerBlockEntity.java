package me.khajiitos.potionvapes.common.blockentity;

import me.khajiitos.potionvapes.common.item.VapeJuiceItem;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VapeJuicerBlockEntity extends BlockEntity {
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

    public static void serverTick(Level level, BlockPos blockPos, BlockState blockState, VapeJuicerBlockEntity blockEntity) {
        ItemStack itemFirst = blockEntity.items.get(0);
        ItemStack itemSecond = blockEntity.items.get(1);

        boolean updated = false;

        ItemStack result;
        if (itemFirst.getItem() instanceof VapeJuiceItem vapeJuiceItem && itemSecond.getItem() instanceof PotionItem) {
            result = itemFirst.copy();
            vapeJuiceItem.
            //TODO FINISH
        }

        if (result != null) {
            blockEntity.progress++;
            updated = true;
        }

        if (blockEntity.progress >= MAX_PROGRESS) {
            blockEntity.progress = 0;
            updated = true;
        }

        if (updated) {
            blockEntity.setChanged();
        }
    }

    public int getProgress() {
        return this.progress;
    }
}
