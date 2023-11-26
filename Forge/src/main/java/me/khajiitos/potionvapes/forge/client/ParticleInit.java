package me.khajiitos.potionvapes.forge.client;

import me.khajiitos.potionvapes.common.particle.VapeSmokeParticle;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ParticleInit {

    private static void onRegisterParticleProviders(RegisterParticleProvidersEvent e) {
        e.register(VapeParticles.VAPE_SMOKE, VapeSmokeParticle.Provider::new);
    }

    public static void init(IEventBus eventBus) {
        eventBus.addListener(ParticleInit::onRegisterParticleProviders);
    }
}
