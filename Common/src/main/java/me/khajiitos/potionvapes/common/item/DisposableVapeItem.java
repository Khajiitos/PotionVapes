package me.khajiitos.potionvapes.common.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

public class DisposableVapeItem extends VapeItem {
    public DisposableVapeItem(DyeColor dyeColor) {
        super(64);
    }

    public DisposableVapeItem() {
        super(64);
    }

    @Override
    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }
}
