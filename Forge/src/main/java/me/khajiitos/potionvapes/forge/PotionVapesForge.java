package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantmentCategory;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.forge.client.PotionVapesClient;
import me.khajiitos.potionvapes.forge.packet.ForgePacketManager;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PotionVapes.MOD_ID)
public class PotionVapesForge {

    public PotionVapesForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PacketManager.instance = new ForgePacketManager();

        VapeEnchantmentCategory.CATEGORY = EnchantmentCategory.create("VAPE", VapeEnchantmentCategory.PREDICATE);
        BlockInit.init(eventBus);
        ItemInit.init(eventBus);
        SoundInit.init(eventBus);
        BlockEntityInit.init(eventBus);
        MenuInit.init(eventBus);
        EnchantmentInit.init(eventBus);
        LootTablesInit.init(eventBus);
        ParticleTypeInit.init(eventBus);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> PotionVapesClient::init);
        MinecraftForge.EVENT_BUS.addListener(PotionVapesForge::onServerTick);
    }

    public static void onServerTick(TickEvent.ServerTickEvent e) {
        if (e.phase == TickEvent.Phase.START) {
            TickDelayedCalls.tick(e.getServer());
        }
    }
}