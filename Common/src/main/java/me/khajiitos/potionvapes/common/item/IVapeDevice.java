package me.khajiitos.potionvapes.common.item;

import net.minecraft.world.item.ItemStack;

public interface IVapeDevice extends IVapeJuice {
    double getVapeJuiceUsagePerTick(ItemStack itemStack);
    double getVapeJuiceReleasePerTick(ItemStack itemStack);

    default void emptyVapeJuice(ItemStack itemStack) {
        itemStack.getOrCreateTag().remove("VapeJuice");
    };
}
