package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.block.VapeJuicerBlock;
import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PotionVapes.MOD_ID);

    private static final RegistryObject<? extends BlockEntityType<? extends VapeJuicerBlockEntity>> VAPE_JUICER = BLOCK_ENTITY_TYPES.register("vape_juicer", () -> {
        VapeBlockEntities.VAPE_JUICER = BlockEntityType.Builder.of(VapeJuicerBlockEntity::new, VapeBlocks.VAPE_JUICER).build(null);
        return VapeBlockEntities.VAPE_JUICER;
    });

    public static void init(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
