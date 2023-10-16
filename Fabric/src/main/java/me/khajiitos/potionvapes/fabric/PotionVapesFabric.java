package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.fabric.packet.FabricPacketManager;
import me.khajiitos.potionvapes.fabric.packet.ClientFabricPackets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.renderer.ItemInHandRenderer;

public class PotionVapesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        PacketManager.instance = new FabricPacketManager();

        BlockInit.init();
        ItemInit.init();
        SoundInit.init();
        BlockEntityInit.init();
        MenuInit.init();
        EnchantmentInit.init();
        LootTablesInit.init();
    }
}