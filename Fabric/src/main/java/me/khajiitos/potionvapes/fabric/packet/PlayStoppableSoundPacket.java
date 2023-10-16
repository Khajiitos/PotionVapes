package me.khajiitos.potionvapes.fabric.packet;

import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;

public class PlayStoppableSoundPacket {
    public static void sendStoppableSound(ServerPlayer to, Entity entity, SoundEvent soundEvent, SoundSource source, double x, double y, double z, float volume, float pitch) {
        FriendlyByteBuf buf = PacketByteBufs.create();

        buf.writeInt(entity.getId());
        soundEvent.writeToNetwork(buf);
        buf.writeEnum(source);
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
        buf.writeFloat(volume);
        buf.writeFloat(pitch);

        ServerPlayNetworking.send(to, ClientFabricPackets.PLAY_STOPPABLE_SOUND_ID, buf);
    }
}
