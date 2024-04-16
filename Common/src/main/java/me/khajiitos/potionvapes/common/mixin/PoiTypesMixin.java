package me.khajiitos.potionvapes.common.mixin;

import me.khajiitos.potionvapes.common.stuff.VapePoiTypes;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(PoiTypes.class)
public abstract class PoiTypesMixin {

    @Shadow
    private static void registerBlockStates(Holder<PoiType> holder, Set<BlockState> blockStates) {}

    @Inject(at = @At("TAIL"), method = "bootstrap")
    private static void bootstrap(Registry<PoiType> registry, CallbackInfoReturnable<PoiType> cir) {
        System.out.println("tetesag");
        Registry.register(registry, VapePoiTypes.VAPE_ADDICT_POI_KEY, VapePoiTypes.VAPE_ADDICT_POI);
        registerBlockStates(registry.getHolderOrThrow(VapePoiTypes.VAPE_ADDICT_POI_KEY), VapePoiTypes.VAPE_ADDICT_POI.matchingStates());
    }
}
