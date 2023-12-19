package me.khajiitos.potionvapes.common.mixin;

import me.khajiitos.potionvapes.common.util.ILungCancerable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements ILungCancerable {

    @Unique
    public double potionvapes$lungCancerProgress;

    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    public void addAdditionalSaveData(CompoundTag compoundTag, CallbackInfo info) {
        compoundTag.putDouble("PotionVapesLungCancerProgress", potionvapes$lungCancerProgress);
    }

    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    public void readAdditionalSaveData(CompoundTag compoundTag, CallbackInfo info) {
        potionvapes$lungCancerProgress = compoundTag.getDouble("PotionVapesLungCancerProgress");
    }

    @Override
    public double getLungCancerProgress() {
        return potionvapes$lungCancerProgress;
    }

    @Override
    public void setLungCancerProgress(double progress) {
        potionvapes$lungCancerProgress = progress;
    }
}