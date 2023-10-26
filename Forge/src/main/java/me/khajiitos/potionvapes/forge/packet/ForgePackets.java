package me.khajiitos.potionvapes.forge.packet;

import me.khajiitos.potionvapes.common.PotionVapes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class ForgePackets {
    private static final String PROTOCOL_VERSION = "1";
    private static int packetsRegistered;

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(PotionVapes.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void init() {
        INSTANCE.registerMessage(packetsRegistered++, PlayStoppableSoundPacket.class, PlayStoppableSoundPacket::encode, PlayStoppableSoundPacket::decode, PlayStoppableSoundPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        INSTANCE.registerMessage(packetsRegistered++, StopStoppableSoundPacket.class, StopStoppableSoundPacket::encode, StopStoppableSoundPacket::decode, StopStoppableSoundPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    }

    public static <MSG> void sendToClient(ServerPlayer player, MSG packet) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }
}
