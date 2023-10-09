package me.khajiitos.potionvapes.common.item;

import net.minecraft.world.item.ItemStack;

public interface IVapeDevice extends IVapeJuice {
    double getVapeJuiceUsagePerTick(ItemStack itemStack);
}
