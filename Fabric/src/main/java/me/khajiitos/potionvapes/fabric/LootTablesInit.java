package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.loot.VapeLootFunctions;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;

import java.util.List;

public class LootTablesInit {
    private static final List<ResourceLocation> INJECT_TO = List.of(
            new ResourceLocation("chests/abandoned_mineshaft"),
            new ResourceLocation("chests/simple_dungeon"),
            new ResourceLocation("chests/shipwreck_treasure")
    );

    private static final ResourceLocation INJECTED_POOL = new ResourceLocation(PotionVapes.MOD_ID, "inject/disposable_vapes");

    public static void init() {
        Registry.register(Registry.LOOT_FUNCTION_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "random_vape_effect"), VapeLootFunctions.RANDOM_VAPE_EFFECT);

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (INJECT_TO.contains(id)) {
                LootPool lootPool = LootPool.lootPool().add(LootTableReference.lootTableReference(INJECTED_POOL)).build();
                tableBuilder.pool(lootPool);
            }
        }));
    }
}
