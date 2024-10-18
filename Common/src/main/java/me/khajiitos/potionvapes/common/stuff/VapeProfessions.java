package me.khajiitos.potionvapes.common.stuff;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.util.function.Predicate;

public class VapeProfessions {
    public static final Predicate<Holder<PoiType>> IS_VAPE_DEALER_KEY = (key) -> key.is(VapePoiTypes.VAPE_DEALER_POI_KEY);

    public static final VillagerProfession VAPE_DEALER = new VillagerProfession("vape_dealer", IS_VAPE_DEALER_KEY, IS_VAPE_DEALER_KEY, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER);
}
