package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class BlockInit {
    public static void init() {
        Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(PotionVapes.MOD_ID, "vape_juicer"), VapeBlocks.VAPE_JUICER);
    }
}
