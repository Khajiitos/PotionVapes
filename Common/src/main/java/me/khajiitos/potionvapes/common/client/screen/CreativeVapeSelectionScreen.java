package me.khajiitos.potionvapes.common.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractScrollWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.network.chat.Component;

public class CreativeVapeSelectionScreen extends Screen {
    public CreativeVapeSelectionScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        super.init();
        //this.addRenderableWidget(new AbstractScrollWidget())
    }

    @Override
    public void render(GuiGraphics guiGraphics, int $$1, int $$2, float $$3) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, $$1, $$2, $$3);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
