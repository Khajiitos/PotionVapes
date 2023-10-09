package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.stuff.VapeSoundEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class SoundInit {

    public static void init() {
        Registry.register(BuiltInRegistries.SOUND_EVENT, "vape", VapeSoundEvents.VAPE);
        Registry.register(BuiltInRegistries.SOUND_EVENT, "exhale", VapeSoundEvents.EXHALE);
    }
}
