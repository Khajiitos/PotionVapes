package me.khajiitos.potionvapes.common.menu;

import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.stuff.VapeMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class VapeJuicerMenu extends AbstractContainerMenu {
    public final VapeJuicerBlockEntity blockEntity;

    public VapeJuicerMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public VapeJuicerMenu(int containerId, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(VapeMenus.VAPE_JUICER_MENU, containerId);

        Container container = new SimpleContainer(3);
        this.addSlot(new Slot(container, 0, 17, 35));
        this.addSlot(new Slot(container, 1, 53, 35));
        this.addSlot(new Slot(container, 2, 125, 35));

        addInventory(inventory);

        Optional<BlockEntity> blockEntityOptional = containerLevelAccess.evaluate((Level::getBlockEntity));
        if (blockEntityOptional.isPresent() && blockEntityOptional.get() instanceof VapeJuicerBlockEntity vapeJuicerBlockEntity) {
            this.blockEntity = vapeJuicerBlockEntity;
        } else {
            this.blockEntity = null;
        }
    }

    public void addInventory(Inventory inventory) {
        int j;
        for(j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
