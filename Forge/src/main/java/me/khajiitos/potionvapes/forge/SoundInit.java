package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.menu.VapeJuicerMenu;
import me.khajiitos.potionvapes.common.stuff.VapeMenus;
import me.khajiitos.potionvapes.common.stuff.VapeSoundEvents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {

    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PotionVapes.MOD_ID);

    private static final RegistryObject<SoundEvent> VAPE = SOUND_EVENTS.register("vape", () -> VapeSoundEvents.VAPE);
    private static final RegistryObject<SoundEvent> EXHALE = SOUND_EVENTS.register("exhale", () -> VapeSoundEvents.EXHALE);

    public static void init(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
