package me.khajiitos.potionvapes.fabric.packet.handler;

import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class PlayStoppableSoundHandler {
    public static void handle(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
        int entityId = buf.readInt();
        //Holder<SoundEvent> sound = buf.readById(Registry.SOUND_EVENT.asHolderIdMap(), SoundEvent::readFromNetwork);
        SoundEvent soundEvent = new SoundEvent(buf.readResourceLocation());
        SoundSource source = buf.readEnum(SoundSource.class);
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float volume = buf.readFloat();
        float pitch = buf.readFloat();

        StoppableSoundManager.playSound(entityId, soundEvent, source, volume, pitch, SoundInstance.createUnseededRandom(), x, y, z);
    }

}
