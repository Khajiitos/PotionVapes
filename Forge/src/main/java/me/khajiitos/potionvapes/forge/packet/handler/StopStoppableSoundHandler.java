package me.khajiitos.potionvapes.forge.packet.handler;

import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import me.khajiitos.potionvapes.forge.packet.StopStoppableSoundPacket;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class StopStoppableSoundHandler {
    public static void handle(StopStoppableSoundPacket msg, Supplier<NetworkEvent.Context> ctx) {
        StoppableSoundManager.stopSound(msg.entityId());
    }
}
