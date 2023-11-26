package me.khajiitos.potionvapes.fabric.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import me.khajiitos.potionvapes.common.client.HudOverlay;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {

    @Shadow private int screenWidth;

    @Shadow private int screenHeight;

    @Inject(at = @At("TAIL"), method = "render")
    public void render(PoseStack poseStack, float f, CallbackInfo ci) {
        HudOverlay.render(poseStack, screenWidth, screenHeight);
    }
}
