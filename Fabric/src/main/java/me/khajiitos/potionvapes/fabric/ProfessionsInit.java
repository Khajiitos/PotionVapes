package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.stuff.VapeProfessions;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ProfessionsInit {
    public static void init() {
        Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, new ResourceLocation(PotionVapes.MOD_ID, "vape_addict"), VapeProfessions.VAPE_ADDICT);
    }
}
