package me.khajiitos.potionvapes.forge.client;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.item.IVapeJuice;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientItemInit {

    public static void init() {
        ItemProperties.register(VapeItems.VAPE_JUICE, new ResourceLocation(PotionVapes.MOD_ID, "juice_left"), ((itemStack, clientLevel, livingEntity, i) -> itemStack.getItem() instanceof IVapeJuice vapeJuice ? (float)vapeJuice.getVapeJuiceLeft(itemStack) : 0.f));
        ItemProperties.registerGeneric(new ResourceLocation(PotionVapes.MOD_ID, "vaping"), ((itemStack, clientLevel, livingEntity, i) -> itemStack.getItem() instanceof IVapeDevice && livingEntity != null && livingEntity.getUseItem() == itemStack ? 1.F : 0.F));
    }
}
