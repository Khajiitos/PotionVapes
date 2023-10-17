package me.khajiitos.potionvapes.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TieredItem;
import org.jetbrains.annotations.NotNull;

public class ReinforcedVapeItem extends VapeItem {
    public ReinforcedVapeItem(int durability) {
        super(durability);
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack testedItem) {
        return testedItem.is(Items.NETHERITE_INGOT);
    }

}
