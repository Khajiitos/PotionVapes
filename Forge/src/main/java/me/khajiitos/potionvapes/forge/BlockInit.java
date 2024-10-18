package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PotionVapes.MOD_ID);

    public static void init(IEventBus eventBus) {
        BLOCKS.register("vape_juicer", () -> VapeBlocks.VAPE_JUICER);
        BLOCKS.register(eventBus);
    }
}
