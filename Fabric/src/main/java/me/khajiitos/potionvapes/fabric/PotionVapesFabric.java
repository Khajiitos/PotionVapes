package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantmentCategory;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.fabric.packet.FabricPacketManager;
import me.khajiitos.potionvapes.fabric.packet.ClientFabricPackets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.lang.reflect.Field;

public class PotionVapesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        PacketManager.instance = new FabricPacketManager();

        // TODO: create new enchantment category
        VapeEnchantmentCategory.CATEGORY = EnchantmentCategory.BREAKABLE;

        BlockInit.init();
        ItemInit.init();
        SoundInit.init();
        BlockEntityInit.init();
        MenuInit.init();
        EnchantmentInit.init();
        LootTablesInit.init();
        ParticleTypeInit.init();

        ServerTickEvents.START_SERVER_TICK.register(TickDelayedCalls::tick);
    }
}