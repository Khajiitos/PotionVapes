package me.khajiitos.potionvapes.common.client;

import me.khajiitos.potionvapes.common.item.CreativeVapeItem;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class HudOverlay {

    public static void render(GuiGraphics guiGraphics) {
        LocalPlayer player = Minecraft.getInstance().player;

        if (player == null) {
            return;
        }

        for (InteractionHand interactionHand : InteractionHand.values()) {
            ItemStack itemStack = player.getItemInHand(interactionHand);

            if (itemStack.getItem() instanceof IVapeDevice vapeDevice) {
                ItemStack vapeJuiceItemStack = new ItemStack(VapeItems.VAPE_JUICE);
                VapeItems.VAPE_JUICE.setVapeJuicePotion(vapeJuiceItemStack, vapeDevice.getVapeJuicePotion(itemStack));
                VapeItems.VAPE_JUICE.setVapeJuiceLeft(vapeJuiceItemStack, vapeDevice.getVapeJuiceLeft(itemStack));

                Component leftComponent;

                if (vapeDevice instanceof CreativeVapeItem) {
                    leftComponent = Component.literal("∞").withStyle(ChatFormatting.LIGHT_PURPLE);
                } else {
                    int leftPercent = (int)(100.0 * vapeDevice.getVapeJuiceLeft(itemStack));
                    leftComponent = Component.literal(leftPercent + "%").withStyle(leftPercent > 0 ? ChatFormatting.GRAY : ChatFormatting.RED);
                }

                if (interactionHand == InteractionHand.MAIN_HAND) {
                    guiGraphics.renderItem(vapeJuiceItemStack, guiGraphics.guiWidth() - 20, guiGraphics.guiHeight() - 20);
                    guiGraphics.drawString(Minecraft.getInstance().font, leftComponent, guiGraphics.guiWidth() - 20 - Minecraft.getInstance().font.width(leftComponent), guiGraphics.guiHeight() - 16, 0xFFFFFFFF);
                } else {
                    guiGraphics.renderItem(vapeJuiceItemStack, 4, guiGraphics.guiHeight() - 20);
                    guiGraphics.drawString(Minecraft.getInstance().font, leftComponent, 20, guiGraphics.guiHeight() - 16, 0xFFFFFFFF);
                }
            }
        }
    }
}
