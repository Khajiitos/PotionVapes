package me.khajiitos.potionvapes.common.stuff;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import me.khajiitos.potionvapes.common.item.VapeItem;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class VapeVillagerTrades {

    public static void init() {
        VillagerTrades.TRADES.put(VapeProfessions.VAPE_ADDICT, new Int2ObjectOpenHashMap<>(ImmutableMap.of(
                1, new VillagerTrades.ItemListing[]{
                        new VapesForEmeralds()
                },
                2, new VillagerTrades.ItemListing[]{},
                3, new VillagerTrades.ItemListing[]{},
                4, new VillagerTrades.ItemListing[]{},
                5, new VillagerTrades.ItemListing[]{}
        )));
    }

    private static class VapesForEmeralds implements VillagerTrades.ItemListing {

        @Nullable
        @Override
        public MerchantOffer getOffer(@NotNull Entity entity, @NotNull RandomSource randomSource) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(VapeItems.VAPE), 4, 4, 4.f);
        }
    }
}
