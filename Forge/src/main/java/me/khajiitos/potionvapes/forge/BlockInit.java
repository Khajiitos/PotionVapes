package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.block.VapeJuicerBlock;
import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PotionVapes.MOD_ID);

    public static void init(IEventBus eventBus) {
        //VapeBlocks.VAPE_JUICER = new VapeJuicerBlock();
        BLOCKS.register("vape_juicer", () -> new VapeJuicerBlock() {
            @Override
            protected void openMenu(Player player, Level level, BlockPos blockPos) {
                if (player instanceof ServerPlayer serverPlayer && level.getBlockEntity(blockPos) instanceof VapeJuicerBlockEntity blockEntity) {
                    NetworkHooks.openScreen(serverPlayer, blockEntity, blockPos);
                } else {
                    super.openMenu(player, level, blockPos);
                }
            }
        });
        BLOCKS.register(eventBus);
    }
}
