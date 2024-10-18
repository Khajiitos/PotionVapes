package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.stuff.VapeProfessions;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ProfessionsInit {
    private static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, PotionVapes.MOD_ID);

    public static void init(IEventBus eventBus) {
        PROFESSIONS.register("vape_dealer", () -> VapeProfessions.VAPE_DEALER);
        PROFESSIONS.register(eventBus);
    }
}
