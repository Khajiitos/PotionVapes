package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.item.VapeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PotionVapes.MOD_ID);

    private static final RegistryObject<VapeItem> IRON_VAPE = ITEMS.register("iron_vape", () -> new VapeItem(100));

    public static void init(IEventBus eventBus) {
        eventBus.register(ITEMS);
    }
}
