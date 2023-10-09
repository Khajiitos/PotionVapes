package me.khajiitos.potionvapes.fabric.client;

import net.fabricmc.api.ClientModInitializer;

public class PotionVapesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreenInit.init();
    }
}
