package me.khajiitos.potionvapes.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.literal(" "));
        list.add(Component.translatable("potionvapes.creative_vape_description").withStyle(ChatFormatting.DARK_GRAY));
    }
}
