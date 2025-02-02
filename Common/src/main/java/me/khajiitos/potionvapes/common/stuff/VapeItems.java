package me.khajiitos.potionvapes.common.stuff;

import me.khajiitos.potionvapes.common.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class VapeItems {
    public static final VapeItem VAPE = new VapeItem(100);
    public static final VapeItem REINFORCED_VAPE = new ReinforcedVapeItem(300);
    public static final VapeJuiceItem VAPE_JUICE = new VapeJuiceItem();
    public static final CreativeVapeItem CREATIVE_VAPE = new CreativeVapeItem();
    public static final BlockItem VAPE_JUICER = new BlockItem(VapeBlocks.VAPE_JUICER, new Item.Properties());
    public static final DisposableVapeItem WHITE_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.WHITE);
    public static final DisposableVapeItem ORANGE_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.ORANGE);
    public static final DisposableVapeItem MAGENTA_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.MAGENTA);
    public static final DisposableVapeItem LIGHT_BLUE_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.LIGHT_BLUE);
    public static final DisposableVapeItem YELLOW_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.YELLOW);
    public static final DisposableVapeItem LIME_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.LIME);
    public static final DisposableVapeItem PINK_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.PINK);
    public static final DisposableVapeItem GRAY_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.GRAY);
    public static final DisposableVapeItem LIGHT_GRAY_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.LIGHT_GRAY);
    public static final DisposableVapeItem CYAN_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.CYAN);
    public static final DisposableVapeItem PURPLE_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.PURPLE);
    public static final DisposableVapeItem BLUE_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.BLUE);
    public static final DisposableVapeItem BROWN_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.BROWN);
    public static final DisposableVapeItem GREEN_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.GREEN);
    public static final DisposableVapeItem RED_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.RED);
    public static final DisposableVapeItem BLACK_DISPOSABLE_VAPE = new DisposableVapeItem(DyeColor.BLACK);

    public static void addToCreativeTab(CreativeModeTab.Output output) {
        output.accept(VapeItems.VAPE_JUICER);
        output.accept(VapeItems.VAPE_JUICE);
        output.accept(VapeItems.VAPE);
        output.accept(VapeItems.CREATIVE_VAPE);
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
    }
}
