package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.loot.VapeLootFunctions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class LootTablesInit {
    private static final DeferredRegister<LootItemFunctionType> LOOT_FUNCTION_TYPES = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, PotionVapes.MOD_ID);

    private static final List<ResourceLocation> INJECT_TO = List.of(
            new ResourceLocation("chests/abandoned_mineshaft"),
            new ResourceLocation("chests/simple_dungeon"),
            new ResourceLocation("chests/shipwreck_treasure")
    );

    private static final ResourceLocation INJECTED_POOL = new ResourceLocation(PotionVapes.MOD_ID, "inject/disposable_vapes");

    private static void onLootTableLoad(LootTableLoadEvent e) {
        if (INJECT_TO.contains(e.getName())) {
            LootPool lootPool = LootPool.lootPool().add(LootTableReference.lootTableReference(INJECTED_POOL)).build();
            e.getTable().addPool(lootPool);
        }
    }

    public static void init(IEventBus eventBus) {
        MinecraftForge.EVENT_BUS.addListener(LootTablesInit::onLootTableLoad);
        LOOT_FUNCTION_TYPES.register("random_vape_effect", () -> VapeLootFunctions.RANDOM_VAPE_EFFECT);
        LOOT_FUNCTION_TYPES.register(eventBus);
    }
}
