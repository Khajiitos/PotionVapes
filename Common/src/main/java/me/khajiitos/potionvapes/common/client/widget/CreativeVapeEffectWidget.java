package me.khajiitos.potionvapes.common.client.widget;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class CreativeVapeEffectWidget extends AbstractWidget {
    private final Potion potion;

    public CreativeVapeEffectWidget(Potion potion, int x, int y, Component component) {
        super(x, y, 18, 18, component);
        this.potion = potion;
        assert !this.potion.getEffects().isEmpty();
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int x, int y, float v) {
        MobEffectInstance effectInstance = this.potion.getEffects().get(0);
        ResourceLocation key = BuiltInRegistries.MOB_EFFECT.getKey(effectInstance.getEffect());

        if (key != null) {
            guiGraphics.blit(new ResourceLocation(key.getNamespace(), "textures/mob_effect/" + key.getPath() + ".png"), 0, 0, 18, 18, 0, 0, 18, 18);
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
