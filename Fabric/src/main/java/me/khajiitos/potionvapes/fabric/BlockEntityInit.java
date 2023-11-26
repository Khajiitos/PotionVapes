package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityInit {

    public static void init() {
        VapeBlockEntities.VAPE_JUICER = Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "vape_juicer"), FabricBlockEntityTypeBuilder.create(VapeJuicerBlockEntityFabric::new, VapeBlocks.VAPE_JUICER).build());
    }

    private static class VapeJuicerBlockEntityFabric extends VapeJuicerBlockEntity implements ExtendedScreenHandlerFactory {
        public VapeJuicerBlockEntityFabric(BlockPos blockPos, BlockState blockState) {
            super(blockPos, blockState);
        }

        @Override
        public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
            buf.writeBlockPos(this.getBlockPos());
        }
    }
}
