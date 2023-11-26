package me.khajiitos.potionvapes.fabric;

import fuzs.extensibleenums.core.EnumFactories;
import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantmentCategory;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.fabric.packet.FabricPacketManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class PotionVapesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        PacketManager.instance = new FabricPacketManager();

        VapeEnchantmentCategory.CATEGORY = EnumFactories.createEnchantmentCategory("VAPE", VapeEnchantmentCategory.PREDICATE);

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