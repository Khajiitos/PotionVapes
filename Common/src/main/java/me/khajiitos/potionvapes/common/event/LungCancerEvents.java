package me.khajiitos.potionvapes.common.event;

import me.khajiitos.potionvapes.common.effect.VapeMobEffects;
import me.khajiitos.potionvapes.common.util.ILungCancerable;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;

public class LungCancerEvents {

    public static void tickPlayer(Player player) {
        if (player instanceof ILungCancerable lungCancerable) {
            if (player instanceof ServerPlayer serverPlayer) {
                double progress = lungCancerable.getLungCancerProgress();

                if (progress < 1.0) {
                    serverPlayer.removeEffect(VapeMobEffects.LUNG_CANCER);
                    progress = Math.min(0.5, progress);
                    lungCancerable.setLungCancerProgress(progress);
                }

                if (progress > 0.0) {
                    double healAmount = 0.0005 + player.getRandom().nextDouble() * 0.00005;
                    lungCancerable.setLungCancerProgress(Math.max(0.0, progress - healAmount));
                }
            }
        }
    }
}
