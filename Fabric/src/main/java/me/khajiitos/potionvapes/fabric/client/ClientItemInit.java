package me.khajiitos.potionvapes.fabric.client;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.item.IVapeJuice;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.PotionUtils;

public class ClientItemInit {

    public static void init() {
        ColorProviderRegistry.ITEM.register((itemStack, i) -> i <= 0 && itemStack.getItem() instanceof IVapeJuice vapeJuice ? vapeJuice.getVapeJuiceLeft(itemStack) <= 0 ? -1 : PotionUtils.getColor(vapeJuice.getVapeJuicePotion(itemStack)) : -1, VapeItems.VAPE_JUICE);

        ItemProperties.register(VapeItems.VAPE_JUICE, new ResourceLocation(PotionVapes.MOD_ID, "juice_left"), ((itemStack, clientLevel, livingEntity, i) -> itemStack.getItem() instanceof IVapeJuice vapeJuice ? (float)vapeJuice.getVapeJuiceLeft(itemStack) : 0.f));
        ItemProperties.registerGeneric(new ResourceLocation(PotionVapes.MOD_ID, "vaping"), ((itemStack, clientLevel, livingEntity, i) -> itemStack.getItem() instanceof IVapeDevice && livingEntity != null && livingEntity.getUseItem() == itemStack ? 1.F : 0.F));
    }
}
