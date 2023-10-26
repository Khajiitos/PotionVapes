package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.enchantment.EconomicalEnchantment;
import me.khajiitos.potionvapes.common.enchantment.InhalingEnchantment;
import me.khajiitos.potionvapes.common.enchantment.SmokingEnchantment;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, PotionVapes.MOD_ID);

    private static final RegistryObject<InhalingEnchantment> INHALING = ENCHANTMENTS.register("inhaling", () -> VapeEnchantments.INHALING);
    private static final RegistryObject<EconomicalEnchantment> ECONOMICAL = ENCHANTMENTS.register("economical", () -> VapeEnchantments.ECONOMICAL);
    private static final RegistryObject<SmokingEnchantment> SMOKING = ENCHANTMENTS.register("smoking", () -> VapeEnchantments.SMOKING);

    public static void init(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }
}
