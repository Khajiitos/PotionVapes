package me.khajiitos.potionvapes.common.client.screen;

import net.minecraft.client.gui.components.AbstractScrollWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.network.chat.Component;

public class CreativeVapeSelectionScreen extends Screen {
    protected CreativeVapeSelectionScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        super.init();
        this.addRenderableWidget(new AbstractScrollWidget())
    }
}
