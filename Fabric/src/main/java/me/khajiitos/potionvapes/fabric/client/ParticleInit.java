package me.khajiitos.potionvapes.fabric.client;

import me.khajiitos.potionvapes.common.particle.VapeSmokeParticle;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class ParticleInit {

    public static void init() {
        ParticleFactoryRegistry.getInstance().register(VapeParticles.VAPE_SMOKE, VapeSmokeParticle.Provider::new);
    }
}
