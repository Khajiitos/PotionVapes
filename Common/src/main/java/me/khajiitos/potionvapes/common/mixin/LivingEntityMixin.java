package me.khajiitos.potionvapes.common.mixin;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    // FIXME: DEBUG - REMOVE LATER

    @Inject(at = @At("HEAD"), method = "tickEffects", cancellable = true)
    public void tickEffects(CallbackInfo ci) {
        ci.cancel();
    }
}
