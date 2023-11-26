package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.particle.VapeParticleOption;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class ParticleTypeInit {
    public static void init() {
        VapeParticles.VAPE_SMOKE = FabricParticleTypes.complex(VapeParticleOption.DESERIALIZER);
        Registry.register(Registry.PARTICLE_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "vape_smoke"), VapeParticles.VAPE_SMOKE);
    }
}
