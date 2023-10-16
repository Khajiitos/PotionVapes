package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.item.IVapeJuice;
import me.khajiitos.potionvapes.common.item.VapeItem;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;

public class ItemInit {

    private static final CreativeModeTab ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VapeItems.VAPE))
            .title(Component.translatable("itemGroup.potionvapes"))
            .displayItems((parameters, output) -> {
                output.accept(VapeItems.VAPE_JUICER);
                output.accept(VapeItems.VAPE_JUICE);
                output.accept(VapeItems.VAPE);
                output.accept(VapeItems.REINFORCED_VAPE);
                output.accept(VapeItems.WHITE_DISPOSABLE_VAPE);
                output.accept(VapeItems.ORANGE_DISPOSABLE_VAPE);
                output.accept(VapeItems.MAGENTA_DISPOSABLE_VAPE);
                output.accept(VapeItems.LIGHT_BLUE_DISPOSABLE_VAPE);
                output.accept(VapeItems.YELLOW_DISPOSABLE_VAPE);
                output.accept(VapeItems.LIME_DISPOSABLE_VAPE);
                output.accept(VapeItems.PINK_DISPOSABLE_VAPE);
                output.accept(VapeItems.GRAY_DISPOSABLE_VAPE);
                output.accept(VapeItems.LIGHT_GRAY_DISPOSABLE_VAPE);
                output.accept(VapeItems.CYAN_DISPOSABLE_VAPE);
                output.accept(VapeItems.PURPLE_DISPOSABLE_VAPE);
                output.accept(VapeItems.BLUE_DISPOSABLE_VAPE);
                output.accept(VapeItems.BROWN_DISPOSABLE_VAPE);
                output.accept(VapeItems.GREEN_DISPOSABLE_VAPE);
                output.accept(VapeItems.RED_DISPOSABLE_VAPE);
                output.accept(VapeItems.BLACK_DISPOSABLE_VAPE);
            })
            .build();

    public static void init() {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "vape"), VapeItems.VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "reinforced_vape"), VapeItems.REINFORCED_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "vape_juicer"), VapeItems.VAPE_JUICER);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "vape_juice"), VapeItems.VAPE_JUICE);

        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "white_disposable_vape"), VapeItems.WHITE_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "orange_disposable_vape"), VapeItems.ORANGE_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "magenta_disposable_vape"), VapeItems.MAGENTA_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "light_blue_disposable_vape"), VapeItems.LIGHT_BLUE_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "yellow_disposable_vape"), VapeItems.YELLOW_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "lime_disposable_vape"), VapeItems.LIME_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "pink_disposable_vape"), VapeItems.PINK_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "gray_disposable_vape"), VapeItems.GRAY_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "light_gray_disposable_vape"), VapeItems.LIGHT_GRAY_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "cyan_disposable_vape"), VapeItems.CYAN_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "purple_disposable_vape"), VapeItems.PURPLE_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "blue_disposable_vape"), VapeItems.BLUE_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "brown_disposable_vape"), VapeItems.BROWN_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "green_disposable_vape"), VapeItems.GREEN_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "red_disposable_vape"), VapeItems.RED_DISPOSABLE_VAPE);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PotionVapes.MOD_ID, "black_disposable_vape"), VapeItems.BLACK_DISPOSABLE_VAPE);

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(PotionVapes.MOD_ID, "potion_vapes"), ITEM_GROUP);
    }
}
