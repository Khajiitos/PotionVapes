package me.khajiitos.potionvapes.fabric.client;

import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.fabric.ParticleInit;
import me.khajiitos.potionvapes.fabric.packet.ClientFabricPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class PotionVapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientFabricPackets.init();
        ClientItemInit.init();
        MenuScreenInit.init();
        ParticleInit.init();

        // TODO: this might need to work on the server too, right?
        ClientTickEvents.START_CLIENT_TICK.register(mc -> TickDelayedCalls.tick());
    }
}
