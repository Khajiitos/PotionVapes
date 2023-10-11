package me.khajiitos.potionvapes.fabric.client;

import me.khajiitos.potionvapes.common.client.screen.VapeJuicerScreen;
import me.khajiitos.potionvapes.common.stuff.VapeMenus;
import net.minecraft.client.gui.screens.MenuScreens;

public class MenuScreenInit {

    public static void init() {
        MenuScreens.register(VapeMenus.VAPE_JUICER_MENU, VapeJuicerScreen::new);
    }
}
