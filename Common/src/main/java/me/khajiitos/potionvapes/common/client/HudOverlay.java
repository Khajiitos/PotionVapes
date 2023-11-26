package me.khajiitos.potionvapes.common.client;

import com.mojang.blaze3d.vertex.PoseStack;
import me.khajiitos.potionvapes.common.item.IVapeDevice;
import me.khajiitos.potionvapes.common.stuff.VapeItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class HudOverlay {

    public static void render(PoseStack poseStack, int width, int height) {
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

                int leftPercent = (int)(100.0 * vapeDevice.getVapeJuiceLeft(itemStack));
                Component leftComponent = Component.literal(leftPercent + "%").withStyle(leftPercent > 0 ? ChatFormatting.GRAY : ChatFormatting.RED);

                if (interactionHand == InteractionHand.MAIN_HAND) {
                    Minecraft.getInstance().getItemRenderer().renderGuiItem(vapeJuiceItemStack, width - 20, height - 20);
                    Minecraft.getInstance().font.draw(poseStack, leftComponent, width - 20 - Minecraft.getInstance().font.width(leftComponent), height - 16, 0xFFFFFFFF);
                } else {
                    Minecraft.getInstance().getItemRenderer().renderGuiItem(vapeJuiceItemStack, 4, height - 20);
                    Minecraft.getInstance().font.draw(poseStack, leftComponent, 20, height - 16, 0xFFFFFFFF);
                }
            }
        }
    }
}
