package me.khajiitos.potionvapes.common.loot;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RandomVapeEffectFunction implements LootItemFunction {
    @Override
    public @NotNull LootItemFunctionType getType() {
        return VapeLootFunctions.RANDOM_VAPE_EFFECT;
    }

    @Override
    public ItemStack apply(ItemStack itemStack, LootContext lootContext) {
        if (itemStack.getItem() instanceof IVapeDevice vapeDevice) {
            List<Potion> potions = Registry.POTION.stream().filter(potion -> {
                if (potion.getEffects().size() != 1) {
                    return false;
                }

                MobEffect mobEffect = potion.getEffects().get(0).getEffect();

                return mobEffect.isBeneficial() && !mobEffect.isInstantenous();
            }).toList();

            Potion selectedPotion = potions.get(lootContext.getRandom().nextInt(potions.size()));

            vapeDevice.setVapeJuicePotion(itemStack, selectedPotion);
            vapeDevice.setVapeJuiceLeft(itemStack, 0.75 + (0.01 * lootContext.getRandom().nextInt(26)));

            return itemStack;
        }
        return itemStack;
    }

    public static class Serializer implements net.minecraft.world.level.storage.loot.Serializer<RandomVapeEffectFunction> {
        @Override
        public void serialize(@NotNull JsonObject jsonObject, @NotNull RandomVapeEffectFunction randomVapeEffectFunction, @NotNull JsonSerializationContext jsonSerializationContext) {}

        @Override
        public @NotNull RandomVapeEffectFunction deserialize(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext jsonDeserializationContext) {
            return new RandomVapeEffectFunction();
        }
    }
}
