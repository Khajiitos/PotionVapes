package me.khajiitos.potionvapes.forge.event;

import me.khajiitos.potionvapes.common.effect.VapeMobEffects;
import me.khajiitos.potionvapes.common.util.ILungCancerable;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeLungCancerEvents {

    @SubscribeEvent
    public static void onPotionEffectRemoved(MobEffectEvent.Remove e) {
        if (e.getEffect() == VapeMobEffects.LUNG_CANCER && e.getEntity() instanceof ILungCancerable lungCancerable) {
            double lungCancerProgress = lungCancerable.getLungCancerProgress();

            if (lungCancerProgress >= 1.00) {
                e.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onDrinkMilk(LivingEntityUseItemEvent.Finish e) {
        if (e.getItem().getItem() == Items.MILK_BUCKET && e.getEntity() instanceof ILungCancerable lungCancerable) {
            double lungCancerProgress = lungCancerable.getLungCancerProgress();
            lungCancerable.setLungCancerProgress(Math.max(0.0, lungCancerProgress - 0.05));
        }
    }
}
