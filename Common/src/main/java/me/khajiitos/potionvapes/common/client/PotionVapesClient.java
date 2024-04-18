package me.khajiitos.potionvapes.common.client;

import me.khajiitos.potionvapes.common.client.screen.CreativeVapeSelectionScreen;
import net.minecraft.client.Minecraft;

public class PotionVapesClient {

    public static void openCreativeVapeScreen() {
        Minecraft.getInstance().setScreen(new CreativeVapeSelectionScreen());
    }
}
