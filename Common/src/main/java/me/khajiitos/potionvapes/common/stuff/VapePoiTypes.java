package me.khajiitos.potionvapes.common.stuff;

import com.google.common.collect.ImmutableSet;
import me.khajiitos.potionvapes.common.PotionVapes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class VapePoiTypes {
    public static final PoiType VAPE_DEALER_POI = new PoiType(ImmutableSet.copyOf(VapeBlocks.VAPE_JUICER.getStateDefinition().getPossibleStates()), 1, 1);
    public static final ResourceKey<PoiType> VAPE_DEALER_POI_KEY = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "vape_dealer"));
}
