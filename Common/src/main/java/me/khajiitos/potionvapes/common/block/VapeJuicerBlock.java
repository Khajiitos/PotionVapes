package me.khajiitos.potionvapes.common.block;

import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.menu.VapeJuicerMenu;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VapeJuicerBlock extends BaseEntityBlock {
    public VapeJuicerBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).strength(0.8F).requiresCorrectToolForDrops().sound(SoundType.STONE));
        VapeBlocks.VAPE_JUICER = this;
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState $$0) {
        return RenderShape.MODEL;
    }

    protected void openMenu(Player player, Level level, BlockPos blockPos) {
        player.openMenu(level.getBlockState(blockPos).getMenuProvider(level, blockPos));
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            openMenu(player, level, blockPos);
            return InteractionResult.CONSUME;
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public MenuProvider getMenuProvider(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos) {
        return new SimpleMenuProvider((id, inventory, player) -> new VapeJuicerMenu(id, inventory, ContainerLevelAccess.create(level, blockPos)), Component.translatable("potionvapes.container.vape_juicer"));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return VapeBlockEntities.VAPE_JUICER.create(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, VapeBlockEntities.VAPE_JUICER, VapeJuicerBlockEntity::serverTick);
    }
}
