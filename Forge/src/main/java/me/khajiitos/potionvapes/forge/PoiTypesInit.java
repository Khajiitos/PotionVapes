package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.stuff.VapePoiTypes;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PoiTypesInit {
    private static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, PotionVapes.MOD_ID);

    public static void init(IEventBus eventBus) {
        POI_TYPES.register("vape_dealer", () -> VapePoiTypes.VAPE_DEALER_POI);
        POI_TYPES.register(eventBus);
    }
}
