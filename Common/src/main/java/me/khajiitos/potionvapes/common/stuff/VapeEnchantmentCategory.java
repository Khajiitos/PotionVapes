package me.khajiitos.potionvapes.common.stuff;

import me.khajiitos.potionvapes.common.item.DisposableVapeItem;
import me.khajiitos.potionvapes.common.item.VapeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.function.Predicate;

public class VapeEnchantmentCategory {
    public static EnchantmentCategory CATEGORY;
    public static final Predicate<Item> PREDICATE = item -> item instanceof VapeItem && !(item instanceof DisposableVapeItem);
}