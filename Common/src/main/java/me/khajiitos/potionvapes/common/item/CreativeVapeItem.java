package me.khajiitos.potionvapes.common.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

public class CreativeVapeItem extends VapeItem {
    public CreativeVapeItem() {
        super(-1);
    }

    @Override
    public double getVapeJuiceUsagePerTick(ItemStack itemStack) {
        return 0.0;
    }

    @Override
    public @NotNull Rarity getRarity(@NotNull ItemStack itemStack) {
        return Rarity.EPIC;
    }
}
