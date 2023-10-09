package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantments;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class EnchantmentInit {

    public static void init() {
        Registry.register(BuiltInRegistries.ENCHANTMENT, new ResourceLocation(PotionVapes.MOD_ID, "inhaling"), VapeEnchantments.INHALING);
        Registry.register(BuiltInRegistries.ENCHANTMENT, new ResourceLocation(PotionVapes.MOD_ID, "economical"), VapeEnchantments.ECONOMICAL);
    }
}
