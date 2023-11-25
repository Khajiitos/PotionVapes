package me.khajiitos.potionvapes.common.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DisposableVapeItem extends VapeItem {
    public DisposableVapeItem(DyeColor dyeColor) {
        super(64);
    }

    public DisposableVapeItem() {
        super(64);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack itemStack) {
        return false;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack testedItem) {
        return false;
    }

    @Override
    public boolean canReplaceJuice() {
        return false;
    }
}
