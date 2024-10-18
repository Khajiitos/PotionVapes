package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.block.VapeJuicerBlock;
import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.util.LoaderController;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public final class ForgeLoaderController extends LoaderController {
    @Override
    public VapeJuicerBlock createVapeJuicerBlock() {
        return new VapeJuicerBlock() {
            @Override
            protected void openMenu(Player player, Level level, BlockPos blockPos) {
                if (player instanceof ServerPlayer serverPlayer && level.getBlockEntity(blockPos) instanceof VapeJuicerBlockEntity blockEntity) {
                    NetworkHooks.openScreen(serverPlayer, blockEntity, blockPos);
                } else {
                    super.openMenu(player, level, blockPos);
                }
            }
        };
    }

    @Override
    public Type getLoaderType() {
        return Type.FORGE;
    }
}
