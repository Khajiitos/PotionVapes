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
                        new DisposableVapeForEmeralds(),
                        new VapeForEmeralds(false)
                },
                3, new VillagerTrades.ItemListing[]{
                        new VapeJuicesForEmeralds(),
                        new VapeJuicesForEmeralds(),
                        new VapeForEmeralds(true)
                },
                4, new VillagerTrades.ItemListing[]{
                        new VapeJuicesForEmeralds(),
                        new VapeJuicesForEmeralds(),
                },
                5, new VillagerTrades.ItemListing[]{
                        new VapeJuicesForEmeralds(),
                        new VapeJuicesForEmeralds()
                }
        )));
    }

    private static class VapeJuicesForEmeralds implements VillagerTrades.ItemListing {
        @Nullable
        @Override
        public MerchantOffer getOffer(@NotNull Entity entity, @NotNull RandomSource randomSource) {
            List<Potion> potions = BuiltInRegistries.POTION.stream().filter(potion -> {
                if (potion.getEffects().size() != 1) {
                    return false;
                }
                MobEffect mobEffect = potion.getEffects().get(0).getEffect();
                return mobEffect.isBeneficial() && !mobEffect.isInstantenous();
            }).toList();

            Potion selectedPotion = potions.get(randomSource.nextInt(potions.size()));

            ItemStack result = new ItemStack(VapeItems.VAPE_JUICE, 1);
            VapeItems.VAPE_JUICE.setVapeJuicePotion(result, selectedPotion);
            VapeItems.VAPE_JUICE.setVapeJuiceLeft(result, 1.0);

            return new MerchantOffer(new ItemStack(Items.EMERALD, randomSource.nextInt(2, 10)), result, 4, 4, 4.f);
        }
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
                return mobEffect.isBeneficial() && !mobEffect.isInstantenous();
            }).toList();

            Potion selectedPotion = potions.get(randomSource.nextInt(potions.size()));

            ItemStack result = new ItemStack(disposableVapeItem, 1);
            disposableVapeItem.setVapeJuicePotion(result, selectedPotion);
            disposableVapeItem.setVapeJuiceLeft(result, 1.0);

            return new MerchantOffer(new ItemStack(Items.EMERALD, randomSource.nextInt(3, 12)), result, 4, 4, 4.f);
        }
    }

    private static class VapeForEmeralds implements VillagerTrades.ItemListing {
        private final boolean reinforced;

        VapeForEmeralds(boolean reinforced) {
            this.reinforced = reinforced;
        }


        @Nullable
        @Override
        public MerchantOffer getOffer(@NotNull Entity entity, @NotNull RandomSource randomSource) {
            return new MerchantOffer(new ItemStack(Items.EMERALD, reinforced ? randomSource.nextInt(8, 12) : randomSource.nextInt(4, 8)), new ItemStack(reinforced ? VapeItems.REINFORCED_VAPE : VapeItems.VAPE), 4, 4, 4.f);
        }
    }
}
