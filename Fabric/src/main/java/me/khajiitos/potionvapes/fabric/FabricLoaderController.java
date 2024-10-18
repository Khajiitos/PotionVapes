package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.block.VapeJuicerBlock;
import me.khajiitos.potionvapes.common.util.LoaderController;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class FabricLoaderController extends LoaderController {
    @Override
    public VapeJuicerBlock createVapeJuicerBlock() {
       return new VapeJuicerBlock() {
           @Override
           public MenuProvider getMenuProvider(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos) {
               if (level.getBlockEntity(blockPos) instanceof ExtendedScreenHandlerFactory extendedScreenHandlerFactory) {
                   return extendedScreenHandlerFactory;
               } else {
                   return null;
               }
           }
       };
    }

    @Override
    public Type getLoaderType() {
        return Type.FABRIC;
    }
}
