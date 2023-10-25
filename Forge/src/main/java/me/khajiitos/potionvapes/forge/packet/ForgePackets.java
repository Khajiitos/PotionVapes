package me.khajiitos.potionvapes.forge.packet;

import me.khajiitos.potionvapes.common.PotionVapes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkInstance;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

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
        //INSTANCE.registerMessage(packetsRegistered++, PlayStoppableSoundPacket.class, );
    }
}
