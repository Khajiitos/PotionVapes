package me.khajiitos.potionvapes.fabric.packet.handler;

import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;

public class StopStoppableSoundHandler {
    public static void handle(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        StoppableSoundManager.stopSound(buf.readInt());
    }
}
