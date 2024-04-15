package me.khajiitos.potionvapes.fabric;

import fuzs.extensibleenums.api.extensibleenums.v1.BuiltInEnumFactories;
import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.event.LungCancerEvents;
import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantmentCategory;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.fabric.packet.FabricPacketManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.entity.ai.behavior.GoToPotentialJobSite;
import net.minecraft.world.entity.ai.behavior.WorkAtComposter;
import net.minecraft.world.entity.ai.behavior.WorkAtPoi;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.block.Blocks;

public class PotionVapesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        PotionVapes.init();
        PacketManager.instance = new FabricPacketManager();

        VapeEnchantmentCategory.CATEGORY = BuiltInEnumFactories.createEnchantmentCategory("VAPE", VapeEnchantmentCategory.PREDICATE);

        BlockInit.init();
        ItemInit.init();
        SoundInit.init();
        BlockEntityInit.init();
        MenuInit.init();
        EnchantmentInit.init();
        LootTablesInit.init();
        ParticleTypeInit.init();
        MobEffectInit.init();
        ProfessionsInit.init();

        ServerTickEvents.START_SERVER_TICK.register(TickDelayedCalls::tick);
        ServerTickEvents.START_SERVER_TICK.register((server) -> server.getPlayerList().getPlayers().forEach(LungCancerEvents::tickPlayer));
    }
}