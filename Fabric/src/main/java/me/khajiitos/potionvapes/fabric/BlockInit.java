package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.block.VapeJuicerBlock;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.mixin.screenhandler.NamedScreenHandlerFactoryMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockInit {
    public static void init() {
        VapeBlocks.VAPE_JUICER = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PotionVapes.MOD_ID, "vape_juicer"), new VapeJuicerBlock() {
            @Override
            public MenuProvider getMenuProvider(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos) {
                if (level.getBlockEntity(blockPos) instanceof ExtendedScreenHandlerFactory extendedScreenHandlerFactory) {
                    return extendedScreenHandlerFactory;
                } else {
                    return null;
                }
            }
        });
    }
}
