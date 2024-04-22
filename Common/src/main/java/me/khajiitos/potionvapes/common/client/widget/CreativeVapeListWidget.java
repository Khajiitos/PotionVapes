package me.khajiitos.potionvapes.common.client.widget;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractScrollWidget;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.alchemy.Potion;

import java.util.ArrayList;
import java.util.List;

public class CreativeVapeListWidget extends AbstractScrollWidget {
    public final List<AbstractWidget> children = new ArrayList<>();

    public CreativeVapeListWidget(int $$0, int $$1, int $$2, int $$3, Component $$4) {
        super($$0, $$1, $$2, $$3, $$4);

        for (Potion potion : BuiltInRegistries.POTION) {
            if (potion.getEffects().isEmpty()) {
                continue;
            }

            this.children.add(new CreativeVapeEffectWidget(potion, 0, 0, Component.empty()));
        }
    }

    @Override
    protected int getInnerHeight() {
        int y = 0;

        for (AbstractWidget widget : children) {
            y += widget.getHeight() + 2;
        }

        return y;
    }

    @Override
    protected double scrollRate() {
        return 0.5;
    }

    @Override
    protected void renderContents(GuiGraphics guiGraphics, int x, int y, float partialTick) {
        for (AbstractWidget widget : children) {
            widget.render(guiGraphics, x, y, partialTick);
            y += widget.getHeight() + 2;
        }
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
