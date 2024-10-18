package me.khajiitos.potionvapes.common.stuff;

import me.khajiitos.potionvapes.common.PotionVapes;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class VapeDamageTypes {
    private static final ResourceKey<DamageType> VAPE_CHOKE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "vape_choke"));

    public static DamageSource vapeChoke(Level level) {
        Optional<Registry<DamageType>> registry = level.registryAccess().registry(Registries.DAMAGE_TYPE);

        if (registry.isPresent()) {
            Holder<DamageType> holder = registry.get().getHolder(VAPE_CHOKE).orElse(null);
            if (holder != null) {
                return new DamageSource(holder);
            }
        }

        return level.damageSources().generic();
    }
}