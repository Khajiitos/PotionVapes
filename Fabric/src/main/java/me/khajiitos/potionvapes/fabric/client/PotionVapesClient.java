package me.khajiitos.potionvapes.fabric.client;

import me.khajiitos.potionvapes.fabric.packet.ClientFabricPackets;
import net.fabricmc.api.ClientModInitializer;

public class PotionVapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientFabricPackets.init();
        ClientItemInit.init();
        MenuScreenInit.init();
        ParticleInit.init();

        //ClientTickEvents.START_CLIENT_TICK.register(mc -> TickDelayedCalls.tick());
    }
}
