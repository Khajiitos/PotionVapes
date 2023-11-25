package me.khajiitos.potionvapes.common.enchantment;

import me.khajiitos.potionvapes.common.item.DisposableVapeItem;
import me.khajiitos.potionvapes.common.item.VapeItem;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantmentCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class EconomicalEnchantment extends Enchantment {
    public EconomicalEnchantment() {
        super(Enchantment.Rarity.UNCOMMON, VapeEnchantmentCategory.CATEGORY, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canEnchant(ItemStack itemStack) {
        return itemStack.getItem() instanceof VapeItem && !(itemStack.getItem() instanceof DisposableVapeItem);
    }
}
