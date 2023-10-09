package me.khajiitos.potionvapes.fabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.item.enchantment.Enchantment;

public class PotionVapesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        BlockInit.init();
        ItemInit.init();
        SoundInit.init();
        BlockEntityInit.init();
        MenuInit.init();
        EnchantmentInit.init();
        ParticleInit.init();
        LootTablesInit.init();
    }
}