package me.khajiitos.potionvapes.common.stuff;

import me.khajiitos.potionvapes.common.PotionVapes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class VapeSoundEvents {
    public static final SoundEvent VAPE = new SoundEvent(new ResourceLocation(PotionVapes.MOD_ID, "vape"));
    public static final SoundEvent EXHALE = new SoundEvent(new ResourceLocation(PotionVapes.MOD_ID, "exhale"));
}
