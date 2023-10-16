package me.khajiitos.potionvapes.common.util;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class OutputSlot extends Slot {
    public OutputSlot(Container container, int id, int x, int y) {
        super(container, id, x, y);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack itemStack) {
        return false;
    }
}
