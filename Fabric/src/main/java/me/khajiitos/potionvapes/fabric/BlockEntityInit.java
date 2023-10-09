package me.khajiitos.potionvapes.fabric;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.blockentity.VapeJuicerBlockEntity;
import me.khajiitos.potionvapes.common.stuff.VapeBlockEntities;
import me.khajiitos.potionvapes.common.stuff.VapeBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class BlockEntityInit {

    public static void init() {
        VapeBlockEntities.VAPE_JUICER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(PotionVapes.MOD_ID, "vape_juicer"), FabricBlockEntityTypeBuilder.create(VapeJuicerBlockEntity::new, VapeBlocks.VAPE_JUICER).build());
    }
}
