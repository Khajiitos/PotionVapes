package me.khajiitos.potionvapes.common.stuff;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import me.khajiitos.potionvapes.common.item.DisposableVapeItem;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.item.VapeItem;
import me.khajiitos.potionvapes.common.loot.VapeLootFunctions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public class VapeVillagerTrades {

    public static void init() {
        VillagerTrades.TRADES.put(VapeProfessions.VAPE_ADDICT, new Int2ObjectOpenHashMap<>(ImmutableMap.of(
                1, new VillagerTrades.ItemListing[]{
                        new DisposableVapeForEmeralds(),
                        new DisposableVapeForEmeralds(),
                },
                2, new VillagerTrades.ItemListing[]{
                        new VapesForEmeralds()
                },
                3, new VillagerTrades.ItemListing[]{},
                4, new VillagerTrades.ItemListing[]{},
                5, new VillagerTrades.ItemListing[]{}
        )));
    }

    private static class DisposableVapeForEmeralds implements VillagerTrades.ItemListing {
        @Nullable
        @Override
        public MerchantOffer getOffer(@NotNull Entity entity, @NotNull RandomSource randomSource) {
            final List<DisposableVapeItem> DISPOSABLE_VAPES = BuiltInRegistries.ITEM.stream().filter(item -> item instanceof DisposableVapeItem).map(DisposableVapeItem.class::cast).toList();
            DisposableVapeItem disposableVapeItem = DISPOSABLE_VAPES.get(randomSource.nextInt(DISPOSABLE_VAPES.size()));

            List<Potion> potions = BuiltInRegistries.POTION.stream().filter(potion -> {
                if (potion.getEffects().size() != 1) {
                    return false;
                }
                MobEffect mobEffect = potion.getEffects().get(0).getEffect();
                return !mobEffect.isInstantenous();
            }).toList();

            Potion selectedPotion = potions.get(randomSource.nextInt(potions.size()));

            ItemStack result = new ItemStack(disposableVapeItem, 1);
            disposableVapeItem.setVapeJuicePotion(result, selectedPotion);
            disposableVapeItem.setVapeJuiceLeft(result, 1.0);

            return new MerchantOffer(new ItemStack(Items.EMERALD, randomSource.nextInt(3, 12)), result, 4, 4, 4.f);
        }
    }

    private static class VapesForEmeralds implements VillagerTrades.ItemListing {
        @Nullable
        @Override
        public MerchantOffer getOffer(@NotNull Entity entity, @NotNull RandomSource randomSource) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(VapeItems.VAPE), 4, 4, 4.f);
        }
    }
}
