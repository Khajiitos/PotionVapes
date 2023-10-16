package me.khajiitos.potionvapes.common.loot;

import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.functions.SetInstrumentFunction;

public class VapeLootFunctions {
    public static final LootItemFunctionType RANDOM_VAPE_EFFECT = new LootItemFunctionType(new RandomVapeEffectFunction.Serializer());
}
