package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.effect.VapeMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MobEffectInit {

    private static final DeferredRegister<MobEffect> MOB_EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PotionVapes.MOD_ID);

    public static void init(IEventBus eventBus) {
        MOB_EFFECT.register(eventBus);
        MOB_EFFECT.register("lung_cancer", () -> VapeMobEffects.LUNG_CANCER);
    }
}
