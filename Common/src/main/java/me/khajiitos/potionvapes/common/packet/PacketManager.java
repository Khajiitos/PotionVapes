package me.khajiitos.potionvapes.common.packet;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;

public abstract class PacketManager {
    // Based on the loader, will be either FabricPacketManager or ForgePacketManager
    public static PacketManager instance;

    public abstract void sendStoppableSound(ServerPlayer to, Entity entity, SoundEvent soundEvent, SoundSource source, double x, double y, double z, float volume, float pitch);
    public abstract void sendStopStoppableSound(ServerPlayer to, Entity entity);
}
