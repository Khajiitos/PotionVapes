package me.khajiitos.potionvapes.fabric.packet;

import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

public class StopStoppableSoundPacket {

    public static void sendStopStoppableSound(ServerPlayer to, Entity entity) {
        FriendlyByteBuf buf = PacketByteBufs.create();
        buf.writeInt(entity.getId());
        ServerPlayNetworking.send(to, ClientFabricPackets.STOP_STOPPABLE_SOUND_ID, buf);
    }
}
