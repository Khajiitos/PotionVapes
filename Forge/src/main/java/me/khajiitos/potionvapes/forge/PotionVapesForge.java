package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import me.khajiitos.potionvapes.forge.client.PotionVapesClient;
import me.khajiitos.potionvapes.forge.packet.ForgePacketManager;
import net.minecraft.client.renderer.block.model.ItemOverride;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
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
        // PacketManager is empty, stoppable sound is not sent
        // Vape Juicer menu on client-side doesn't know where the block entity is

        PacketManager.instance = new ForgePacketManager();

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