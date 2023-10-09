package me.khajiitos.potionvapes.forge;

import me.khajiitos.potionvapes.common.PotionVapes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PotionVapes.MOD_ID)
public class PotionVapesForge {

    public PotionVapesForge() {
        ItemInit.init(FMLJavaModLoadingContext.get().getModEventBus());
    }
}