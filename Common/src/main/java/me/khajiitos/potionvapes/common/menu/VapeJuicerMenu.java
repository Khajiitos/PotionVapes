package me.khajiitos.potionvapes.common.menu;

import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.stuff.VapeMenus;
import me.khajiitos.potionvapes.common.util.OutputSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class VapeJuicerMenu extends AbstractContainerMenu {
    public final VapeJuicerBlockEntity blockEntity;

    public VapeJuicerMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, ContainerLevelAccess.NULL);
    }

    public VapeJuicerMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        this(syncId, inventory, buf == null ? ContainerLevelAccess.NULL : ContainerLevelAccess.create(inventory.player.level(), buf.readBlockPos()));
    }

    public int getContainerSize() {
        return 3;
    }

    public VapeJuicerMenu(int containerId, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(VapeMenus.VAPE_JUICER_MENU, containerId);

        Optional<BlockEntity> blockEntityOptional = containerLevelAccess.evaluate((Level::getBlockEntity));
        if (blockEntityOptional.isPresent() && blockEntityOptional.get() instanceof VapeJuicerBlockEntity vapeJuicerBlockEntity) {
            this.blockEntity = vapeJuicerBlockEntity;
        } else {
            this.blockEntity = null;
        }

        Container container = this.blockEntity == null ? new SimpleContainer(3) : this.blockEntity;

        this.addSlot(new Slot(container, 0, 17, 35));
        this.addSlot(new Slot(container, 1, 53, 35));
        this.addSlot(new OutputSlot(container, 2, 125, 35));

        addInventory(inventory);
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
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot.hasItem()) {
            ItemStack itemInSlot = slot.getItem();
            itemStack = itemInSlot.copy();
            if (i < this.getContainerSize()) {
                if (!this.moveItemStackTo(itemInSlot, this.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemInSlot, 0, this.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemInSlot.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity.stillValid(player);
    }
}
