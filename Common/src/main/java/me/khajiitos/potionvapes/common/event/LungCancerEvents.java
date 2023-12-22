package me.khajiitos.potionvapes.common.event;

import me.khajiitos.potionvapes.common.config.ServerVapeConfig;
import me.khajiitos.potionvapes.common.effect.VapeMobEffects;
import me.khajiitos.potionvapes.common.util.ILungCancerable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

public class LungCancerEvents {

    public static void tickPlayer(Player player) {
        if (player instanceof ILungCancerable lungCancerable) {
            double progress = lungCancerable.getLungCancerProgress();

            if (progress < 1.0) {
                if (player.hasEffect(VapeMobEffects.LUNG_CANCER)) {
                    player.removeEffect(VapeMobEffects.LUNG_CANCER);
                    progress = Math.min(0.5, progress);
                    lungCancerable.setLungCancerProgress(progress);
                }
            }

            if (progress > 0.0) {
                double healAmount = 0.000015 + player.getRandom().nextDouble() * 0.000015;
                lungCancerable.setLungCancerProgress(Math.max(0.0, progress - healAmount));
            }
        }

        if (player instanceof ServerPlayer serverPlayer && serverPlayer.hasEffect(VapeMobEffects.LUNG_CANCER) && ServerVapeConfig.cancerMode) {
            int halfMaxSupply = player.getMaxAirSupply() / 2;
            if (player.isUnderWater() && player.getAirSupply() > halfMaxSupply) {
                player.setAirSupply(halfMaxSupply);
            }

            if (player.tickCount % 600 == 0 && player.getRandom().nextBoolean()) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200));
            }

            if (player.tickCount % 90 == 0 && player.getRandom().nextInt(3) == 0) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 1));
            }
        }
    }
}
