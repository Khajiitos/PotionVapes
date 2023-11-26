package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.menu.VapeJuicerMenu;
import me.khajiitos.potionvapes.common.stuff.VapeMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuInit {
    private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PotionVapes.MOD_ID);

    public static final RegistryObject<MenuType<VapeJuicerMenu>> VAPE_JUICER_MENU = MENU_TYPES.register("vape_juicer", () -> {
        VapeMenus.VAPE_JUICER_MENU = new MenuType<>(new IContainerFactory<VapeJuicerMenu>() {
            @Override
            public VapeJuicerMenu create(int windowId, Inventory inv, FriendlyByteBuf data) {
                return new VapeJuicerMenu(windowId, inv, data);
            }
        });
        return VapeMenus.VAPE_JUICER_MENU;
    });

    public static void init(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
        //VapeMenus.VAPE_JUICER_MENU = VAPE_JUICER_MENU.get();
    }
}
