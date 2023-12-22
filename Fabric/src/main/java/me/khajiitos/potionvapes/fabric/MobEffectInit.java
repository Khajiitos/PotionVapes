package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.effect.VapeMobEffects;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class MobEffectInit {
    public static void init() {
        Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(PotionVapes.MOD_ID, "lung_cancer"), VapeMobEffects.LUNG_CANCER);
    }
}
