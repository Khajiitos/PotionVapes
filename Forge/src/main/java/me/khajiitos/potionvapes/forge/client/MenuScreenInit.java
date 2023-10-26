package me.khajiitos.potionvapes.forge.client;

import me.khajiitos.potionvapes.common.client.screen.VapeJuicerScreen;
import me.khajiitos.potionvapes.forge.MenuInit;
import net.minecraft.client.gui.screens.MenuScreens;

public class MenuScreenInit {

    public static void init() {
        MenuScreens.register(MenuInit.VAPE_JUICER_MENU.get(), VapeJuicerScreen::new);
    }
}
