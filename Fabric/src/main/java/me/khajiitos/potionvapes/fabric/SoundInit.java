package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.stuff.VapeSoundEvents;
import net.minecraft.core.Registry;

public class SoundInit {

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, "vape", VapeSoundEvents.VAPE);
        Registry.register(Registry.SOUND_EVENT, "exhale", VapeSoundEvents.EXHALE);
    }
}
