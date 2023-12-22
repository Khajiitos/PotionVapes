package me.khajiitos.potionvapes.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class LungCancerMobEffect extends MobEffect {
    protected LungCancerMobEffect() {
        super(MobEffectCategory.HARMFUL, 0xffeb7f7c);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int tick) {
        if (livingEntity.isUnderWater() && tick % 20 == 0) {
            livingEntity.setAirSupply(livingEntity.getAirSupply() - 1);
        }

        if (tick % 80 == 0 && livingEntity.getRandom().nextInt(3) == 0) {
            if (livingEntity.isSprinting()) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80));
                livingEntity.setSprinting(false);
            }
        }
    }
}
