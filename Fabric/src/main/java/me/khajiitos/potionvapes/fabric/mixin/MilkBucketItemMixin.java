package me.khajiitos.potionvapes.fabric.mixin;

import me.khajiitos.potionvapes.common.util.ILungCancerable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin {

    @Inject(at = @At("TAIL"), method = "finishUsingItem")
    public void finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (livingEntity instanceof ILungCancerable lungCancerable) {
            lungCancerable.setLungCancerProgress(Math.max(0.0, lungCancerable.getLungCancerProgress() - 0.05));
        }
    }
}
