package me.khajiitos.potionvapes.forge.client;

import me.khajiitos.potionvapes.common.client.HudOverlay;
import me.khajiitos.potionvapes.common.item.IVapeJuice;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class PotionVapesClient {
    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(PotionVapesClient::onClientSetup);
        eventBus.addListener(PotionVapesClient::onRegisterColorHandlers);
        MinecraftForge.EVENT_BUS.addListener(PotionVapesClient::onRenderHud);

        ParticleInit.init(eventBus);
    }

    public static void onClientSetup(FMLClientSetupEvent e) {
        MenuScreenInit.init();
        ClientItemInit.init();
    }

    public static void onRegisterColorHandlers(RegisterColorHandlersEvent.Item e) {
        e.register((itemStack, i) -> i <= 0 && itemStack.getItem() instanceof IVapeJuice vapeJuice ? vapeJuice.getVapeJuiceLeft(itemStack) <= 0 ? -1 : PotionUtils.getColor(vapeJuice.getVapeJuicePotion(itemStack)) : -1, VapeItems.VAPE_JUICE);
    }

    public static void onRenderHud(RenderGuiOverlayEvent e) {
        HudOverlay.render(e.getPoseStack(), e.getWindow().getGuiScaledWidth(), e.getWindow().getGuiScaledHeight());
    }
}
