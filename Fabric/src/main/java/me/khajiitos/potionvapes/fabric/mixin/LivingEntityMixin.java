package me.khajiitos.potionvapes.fabric.mixin;

import me.khajiitos.potionvapes.common.effect.VapeMobEffects;
import me.khajiitos.potionvapes.common.util.ILungCancerable;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("RETURN"), method = "removeAllEffects")
    public void onRemoveAllEffects(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity livingEntity = (LivingEntity)(Object)this;

        if (cir.getReturnValueZ() && livingEntity instanceof ILungCancerable lungCancerable && lungCancerable.getLungCancerProgress() >= 1.0) {
            livingEntity.addEffect(new MobEffectInstance(VapeMobEffects.LUNG_CANCER, -1, 0, false, false, true));
        }
    }
}
