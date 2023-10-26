package me.khajiitos.potionvapes.forge.packet;

import me.khajiitos.potionvapes.forge.packet.handler.PlayStoppableSoundHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PlayStoppableSoundPacket(int entityId, SoundEvent soundEvent, SoundSource source, double x, double y, double z, float volume, float pitch) {
    public static void encode(PlayStoppableSoundPacket msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.entityId);
        msg.soundEvent.writeToNetwork(buf);
        buf.writeEnum(msg.source);
        buf.writeDouble(msg.x);
        buf.writeDouble(msg.y);
        buf.writeDouble(msg.z);
        buf.writeFloat(msg.volume);
        buf.writeFloat(msg.pitch);
    }

    public static PlayStoppableSoundPacket decode(FriendlyByteBuf buf) {
        int entityId = buf.readInt();
        SoundEvent soundEvent = SoundEvent.readFromNetwork(buf);
        SoundSource source = buf.readEnum(SoundSource.class);
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float volume = buf.readFloat();
        float pitch = buf.readFloat();

        return new PlayStoppableSoundPacket(entityId, soundEvent, source, x, y, z, volume, pitch);
    }

    public static void handle(PlayStoppableSoundPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> PlayStoppableSoundHandler.handle(msg, ctx));
        ctx.get().setPacketHandled(true);
    }
}
