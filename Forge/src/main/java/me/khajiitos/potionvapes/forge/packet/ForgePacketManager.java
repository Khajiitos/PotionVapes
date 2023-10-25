package me.khajiitos.potionvapes.forge.packet;

import me.khajiitos.potionvapes.common.packet.PacketManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;

public class ForgePacketManager extends PacketManager {
    @Override
    public void sendStoppableSound(ServerPlayer to, Entity entity, SoundEvent soundEvent, SoundSource source, double x, double y, double z, float volume, float pitch) {

    }

    @Override
    public void sendStopStoppableSound(ServerPlayer to, Entity entity) {

    }
}
