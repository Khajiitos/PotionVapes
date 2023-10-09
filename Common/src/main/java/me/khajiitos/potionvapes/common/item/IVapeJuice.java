package me.khajiitos.potionvapes.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;

import java.util.ArrayList;
import java.util.List;

public interface IVapeJuice {
    default Potion getVapeJuicePotion(ItemStack itemStack) {
        return PotionUtils.getPotion(getVapeJuiceTag(itemStack));
    };

    default double getVapeJuiceLeft(ItemStack itemStack) {
        return getVapeJuiceTag(itemStack).getDouble("Left");
    };

    default void setVapeJuicePotionOf(ItemStack itemStack, ItemStack potion) {
        CompoundTag vapeJuiceTag = getVapeJuiceTag(itemStack);
        CompoundTag potionTag = potion.getTag();

        if (potionTag != null && potionTag.contains("Potion")) {
            vapeJuiceTag.putString("Potion", potionTag.getString("Potion"));
        }
    };

    default void setVapeJuiceLeft(ItemStack itemStack, double left) {
        getVapeJuiceTag(itemStack).putDouble("Left", left);
    };

    default CompoundTag getVapeJuiceTag(ItemStack itemStack) {
        return itemStack.getOrCreateTag().getCompound("VapeJuice");
    }

    default List<Component> getInfo(ItemStack itemStack) {
        List<Component> list = new ArrayList<>();
        double left = getVapeJuiceLeft(itemStack);

        if (left <= 0) {
            list.add(Component.translatable("potionvapes.empty").withStyle(ChatFormatting.GRAY));
        } else {
            Potion potion = getVapeJuicePotion(itemStack);
            list.add(Component.translatable("potionvapes.effects").withStyle(ChatFormatting.GRAY));
            PotionUtils.addPotionTooltip(potion.getEffects(), list, 1.f);
        }

        return list;
    }
}