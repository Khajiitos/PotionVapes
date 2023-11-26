package me.khajiitos.potionvapes.common.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.menu.VapeJuicerMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class VapeJuicerScreen extends AbstractContainerScreen<VapeJuicerMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(PotionVapes.MOD_ID, "textures/gui/container/vape_juicer.png");
    private final VapeJuicerBlockEntity blockEntity;

    public VapeJuicerScreen(VapeJuicerMenu vapeJuicerMenu, Inventory inventory, Component component) {
        super(vapeJuicerMenu, inventory, component);
        this.blockEntity = vapeJuicerMenu.blockEntity;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        RenderSystem.setShaderTexture(0, TEXTURE);
        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(PoseStack poseStack, int x, int y, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, x, y, partialTick);

        if (this.blockEntity != null) {
            int progress = this.blockEntity.getProgress();

            if (progress > 0) {
                RenderSystem.setShaderTexture(0, TEXTURE);
                this.blit(poseStack, this.leftPos + 79, this.topPos + 35, 176, 0, (int)(22 * ((float)progress / VapeJuicerBlockEntity.MAX_PROGRESS)), 15);
            }
        }

        this.renderTooltip(poseStack, x, y);
    }
}
