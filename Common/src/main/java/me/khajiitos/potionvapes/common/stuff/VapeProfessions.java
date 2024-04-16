package me.khajiitos.potionvapes.common.stuff;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;

public class VapeProfessions {
    public static final VillagerProfession VAPE_ADDICT = new VillagerProfession("vape_addict", VillagerProfession.ALL_ACQUIRABLE_JOBS, VillagerProfession.ALL_ACQUIRABLE_JOBS, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER);
}
