package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.particle.VapeSmokeParticle;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ParticleInit {
    public static void init() {
        // TODO: this should probably be a complex particle since it has a color
        VapeParticles.VAPE_SMOKE = FabricParticleTypes.simple();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "vape_smoke"), VapeParticles.VAPE_SMOKE);
        ParticleFactoryRegistry.getInstance().register(VapeParticles.VAPE_SMOKE, VapeSmokeParticle.Provider::new);
    }
}
