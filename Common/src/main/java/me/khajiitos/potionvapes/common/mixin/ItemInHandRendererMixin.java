package me.khajiitos.potionvapes.common.mixin;

import me.khajiitos.potionvapes.common.item.IVapeDevice;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {

    @Shadow private ItemStack mainHandItem;

    @Shadow @Final private Minecraft minecraft;

    @Shadow private ItemStack offHandItem;

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isHandsBusy()Z", shift = At.Shift.BEFORE), method = "tick")
    public void afterItemChecks(CallbackInfo ci) {
        // Fix to item disappearing for a split second due to NBT changes while vaping

        if (this.minecraft.player == null || !this.minecraft.player.isUsingItem()) {
            return;
        }

        ItemStack currentMainHandItem = this.minecraft.player.getMainHandItem();
        ItemStack currentOffHandItem = this.minecraft.player.getOffhandItem();

        if (currentMainHandItem.getItem() == this.mainHandItem.getItem() && currentMainHandItem.getItem() instanceof IVapeDevice) {
            this.mainHandItem = currentMainHandItem;
        }

        if (currentOffHandItem.getItem() == this.offHandItem.getItem() && currentOffHandItem.getItem() instanceof IVapeDevice) {
            this.offHandItem = currentOffHandItem;
        }
    }
}
