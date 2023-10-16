package me.khajiitos.potionvapes.fabric.packet;

import me.khajiitos.potionvapes.common.packet.PacketManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;

public class FabricPacketManager extends PacketManager {

    public void sendStoppableSound(ServerPlayer to, Entity entity, SoundEvent soundEvent, SoundSource source, double x, double y, double z, float volume, float pitch) {
        PlayStoppableSoundPacket.sendStoppableSound(to, entity, soundEvent, source, x, y, z, volume, pitch);
    }

    public void sendStopStoppableSound(ServerPlayer to, Entity entity) {
        StopStoppableSoundPacket.sendStopStoppableSound(to, entity);
    }
}
