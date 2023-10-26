package me.khajiitos.potionvapes.forge.packet;

import me.khajiitos.potionvapes.forge.packet.handler.StopStoppableSoundHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record StopStoppableSoundPacket(int entityId) {
    public static void encode(StopStoppableSoundPacket msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.entityId);
    }

    public static StopStoppableSoundPacket decode(FriendlyByteBuf buf) {
        return new StopStoppableSoundPacket(buf.readInt());
    }

    public static void handle(StopStoppableSoundPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> StopStoppableSoundHandler.handle(msg, ctx));
        ctx.get().setPacketHandled(true);
    }
}
