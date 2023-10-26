package me.khajiitos.potionvapes.forge.packet.handler;

import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import me.khajiitos.potionvapes.forge.packet.PlayStoppableSoundPacket;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayStoppableSoundHandler {
    public static void handle(PlayStoppableSoundPacket msg, Supplier<NetworkEvent.Context> ctx) {
        StoppableSoundManager.playSound(msg.entityId(), msg.soundEvent(), msg.source(), msg.volume(), msg.pitch(), SoundInstance.createUnseededRandom(), msg.x(), msg.y(), msg.z());
    }
}
