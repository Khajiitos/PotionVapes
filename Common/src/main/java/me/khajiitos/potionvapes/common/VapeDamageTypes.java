package me.khajiitos.potionvapes.common;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;

public class VapeDamageTypes {
    public static DamageSource vapeChoke(Level level) {
        return new DamageSource("vape_choke"){};
    }
}