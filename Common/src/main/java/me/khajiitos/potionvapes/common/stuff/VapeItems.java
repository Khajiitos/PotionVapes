package me.khajiitos.potionvapes.common.stuff;

import me.khajiitos.potionvapes.common.item.DisposableVapeItem;
import me.khajiitos.potionvapes.common.item.VapeItem;
import me.khajiitos.potionvapes.common.item.VapeJuiceItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class VapeItems {
    public static final VapeItem VAPE = new VapeItem(100);
    public static final VapeItem REINFORCED_VAPE = new VapeItem(300);
    public static final VapeJuiceItem VAPE_JUICE = new VapeJuiceItem();
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

    public static void addToCreativeTab(List<ItemStack> output) {
        output.add(new ItemStack(VapeItems.VAPE_JUICER));
        output.add(new ItemStack(VapeItems.VAPE_JUICE));
        output.add(new ItemStack(VapeItems.VAPE));
        output.add(new ItemStack(VapeItems.REINFORCED_VAPE));
        output.add(new ItemStack(VapeItems.WHITE_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.ORANGE_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.MAGENTA_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.LIGHT_BLUE_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.YELLOW_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.LIME_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.PINK_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.GRAY_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.LIGHT_GRAY_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.CYAN_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.PURPLE_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.BLUE_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.BROWN_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.GREEN_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.RED_DISPOSABLE_VAPE));
        output.add(new ItemStack(VapeItems.BLACK_DISPOSABLE_VAPE));
    }
}
