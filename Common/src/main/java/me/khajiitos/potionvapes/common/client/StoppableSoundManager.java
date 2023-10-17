package me.khajiitos.potionvapes.common.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;

import java.util.HashMap;
import java.util.Map;

public class StoppableSoundManager {
    // Limitation: one sound per entity
    // Fine for our use-case
    private static final Map<Integer, SoundInstance> entitySounds = new HashMap<>();

    public static void playSound(int entityId, SoundInstance soundInstance) {
        stopSound(entityId);
        entitySounds.put(entityId, soundInstance);
        Minecraft.getInstance().getSoundManager().play(soundInstance);
    }

    public static void playSound(int entityId, SoundEvent soundEvent, SoundSource soundSource, float volume, float pitch, RandomSource randomSource, BlockPos blockPos) {
        playSound(entityId, new SimpleSoundInstance(soundEvent, soundSource, volume, pitch, randomSource, blockPos));
    }

    public static void playSound(int entityId, SoundEvent soundEvent, SoundSource soundSource, float volume, float pitch, RandomSource randomSource, double x, double y, double z) {
        playSound(entityId, new SimpleSoundInstance(soundEvent.getLocation(), soundSource, volume, pitch, randomSource, false, 0, SoundInstance.Attenuation.NONE, x, y, z, true));
    }

    public static void stopSound(int entityId) {
        SoundInstance instance = entitySounds.remove(entityId);

        if (instance != null) {
            Minecraft.getInstance().getSoundManager().stop(instance);
        }
    }
}
