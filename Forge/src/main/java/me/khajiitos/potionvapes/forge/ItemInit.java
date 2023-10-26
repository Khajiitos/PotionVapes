package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.item.DisposableVapeItem;
import me.khajiitos.potionvapes.common.item.VapeItem;
import me.khajiitos.potionvapes.common.item.VapeJuiceItem;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PotionVapes.MOD_ID);
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotionVapes.MOD_ID);

    private static final RegistryObject<VapeItem> VAPE = ITEMS.register("vape", () -> VapeItems.VAPE);
    private static final RegistryObject<VapeItem> REINFORCED_VAPE = ITEMS.register("reinforced_vape", () -> VapeItems.REINFORCED_VAPE);
    private static final RegistryObject<DisposableVapeItem> WHITE_DISPOSABLE_VAPE = ITEMS.register("white_disposable_vape", () -> VapeItems.WHITE_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> ORANGE_DISPOSABLE_VAPE = ITEMS.register("orange_disposable_vape", () -> VapeItems.ORANGE_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> MAGENTA_DISPOSABLE_VAPE = ITEMS.register("magenta_disposable_vape", () -> VapeItems.MAGENTA_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> LIGHT_BLUE_DISPOSABLE_VAPE = ITEMS.register("light_blue_disposable_vape", () -> VapeItems.LIGHT_BLUE_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> YELLOW_DISPOSABLE_VAPE = ITEMS.register("yellow_disposable_vape", () -> VapeItems.YELLOW_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> LIME_DISPOSABLE_VAPE = ITEMS.register("lime_disposable_vape", () -> VapeItems.LIME_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> PINK_DISPOSABLE_VAPE = ITEMS.register("pink_disposable_vape", () -> VapeItems.PINK_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> GRAY_DISPOSABLE_VAPE = ITEMS.register("gray_disposable_vape", () -> VapeItems.GRAY_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> LIGHT_GRAY_DISPOSABLE_VAPE = ITEMS.register("light_gray_disposable_vape", () -> VapeItems.LIGHT_GRAY_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> CYAN_DISPOSABLE_VAPE = ITEMS.register("cyan_disposable_vape", () -> VapeItems.CYAN_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> PURPLE_DISPOSABLE_VAPE = ITEMS.register("purple_disposable_vape", () -> VapeItems.PURPLE_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> BLUE_DISPOSABLE_VAPE = ITEMS.register("blue_disposable_vape", () -> VapeItems.BLUE_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> BROWN_DISPOSABLE_VAPE = ITEMS.register("brown_disposable_vape", () -> VapeItems.BROWN_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> GREEN_DISPOSABLE_VAPE = ITEMS.register("green_disposable_vape", () -> VapeItems.GREEN_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> RED_DISPOSABLE_VAPE = ITEMS.register("red_disposable_vape", () -> VapeItems.RED_DISPOSABLE_VAPE);
    private static final RegistryObject<DisposableVapeItem> BLACK_DISPOSABLE_VAPE = ITEMS.register("black_disposable_vape", () -> VapeItems.BLACK_DISPOSABLE_VAPE);
    private static final RegistryObject<VapeJuiceItem> VAPE_JUICE = ITEMS.register("vape_juice", () -> VapeItems.VAPE_JUICE);
    private static final RegistryObject<BlockItem> VAPE_JUICER = ITEMS.register("vape_juicer", () -> VapeItems.VAPE_JUICER);

    private static final RegistryObject<CreativeModeTab> TAB = TABS.register("potion_vapes", () -> CreativeModeTab.builder()
            .displayItems((pParameters, pOutput) -> VapeItems.addToCreativeTab(pOutput))
            .icon(() -> new ItemStack(VapeItems.VAPE))
            .title(Component.translatable("itemGroup.potionvapes"))
            .build());

    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
        TABS.register(eventBus);
    }
}
