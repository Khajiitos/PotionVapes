package me.khajiitos.potionvapes.fabric.packet;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.fabric.packet.handler.PlayStoppableSoundHandler;
import me.khajiitos.potionvapes.fabric.packet.handler.StopStoppableSoundHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.resources.ResourceLocation;

public class ClientFabricPackets {
    public static final ResourceLocation PLAY_STOPPABLE_SOUND_ID = new ResourceLocation(PotionVapes.MOD_ID, "play_stoppable_sound");
    public static final ResourceLocation STOP_STOPPABLE_SOUND_ID = new ResourceLocation(PotionVapes.MOD_ID, "stop_stoppable_sound");

    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(PLAY_STOPPABLE_SOUND_ID, PlayStoppableSoundHandler::handle);
        ClientPlayNetworking.registerGlobalReceiver(STOP_STOPPABLE_SOUND_ID, StopStoppableSoundHandler::handle);
    }
}
