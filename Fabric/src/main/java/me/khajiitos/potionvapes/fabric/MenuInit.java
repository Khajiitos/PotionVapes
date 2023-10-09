package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.menu.VapeJuicerMenu;
import me.khajiitos.potionvapes.common.stuff.VapeMenus;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

public class MenuInit {
    public static void init() {
        VapeMenus.VAPE_JUICER_MENU = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(PotionVapes.MOD_ID, "vape_juicer"), new MenuType<>(VapeJuicerMenu::new, FeatureFlagSet.of()));
    }
}
