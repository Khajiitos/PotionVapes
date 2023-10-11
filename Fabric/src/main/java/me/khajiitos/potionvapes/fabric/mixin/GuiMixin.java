package me.khajiitos.potionvapes.fabric.mixin;

import me.khajiitos.potionvapes.common.client.HudOverlay;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {

    @Inject(at = @At("TAIL"), method = "render")
    public void render(GuiGraphics guiGraphics, float f, CallbackInfo ci) {
        HudOverlay.render(guiGraphics);
    }
}
