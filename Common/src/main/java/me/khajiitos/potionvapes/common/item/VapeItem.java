package me.khajiitos.potionvapes.common.item;

import me.khajiitos.potionvapes.common.VapeDamageTypes;
import me.khajiitos.potionvapes.common.client.StoppableSoundManager;
import me.khajiitos.potionvapes.common.packet.PacketManager;
import me.khajiitos.potionvapes.common.particle.VapeParticleOption;
import me.khajiitos.potionvapes.common.stuff.VapeEnchantments;
import me.khajiitos.potionvapes.common.stuff.VapeSoundEvents;
import me.khajiitos.potionvapes.common.util.TickDelayedCalls;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VapeItem extends Item implements IVapeDevice {
    public VapeItem(int durability) {
        super(new Item.Properties().stacksTo(1).durability(durability));
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (player.isUnderWater() && !player.hasEffect(MobEffects.WATER_BREATHING)) {
            return InteractionResultHolder.consume(itemStack);
        }

        if (getVapeJuiceLeft(itemStack) <= 0) {
            return InteractionResultHolder.fail(itemStack);
        }

        player.startUsingItem(interactionHand);

        if (level.isClientSide) {
            StoppableSoundManager.playSound(player.getId(), VapeSoundEvents.VAPE, SoundSource.PLAYERS, 0.75f, 1.f, player.getRandom(), player.getOnPos().above(2));
        } else {
            for (Player otherPlayer : level.players()) {
                if (otherPlayer == player) {
                    continue;
                }

                if (player.distanceTo(otherPlayer) > 16.0) {
                    continue;
                }

                if (otherPlayer instanceof ServerPlayer otherServerPlayer) {
                    PacketManager.instance.sendStoppableSound(otherServerPlayer, player, VapeSoundEvents.VAPE, SoundSource.PLAYERS, player.getX(), player.getEyeY(), player.getZ(), 0.75f, 1.f);
                }
            }
        }

        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, int tick) {
        int tickIn = getUseDuration(itemStack) - tick;

        if (itemStack.getItem() instanceof IVapeDevice vapeDevice) {
            double left = vapeDevice.getVapeJuiceLeft(itemStack);
            double use = vapeDevice.getVapeJuiceUsagePerTick(itemStack);

            if (left <= use) {
                vapeDevice.emptyVapeJuice(itemStack);
                livingEntity.releaseUsingItem();
                //livingEntity.stopUsingItem();
            }

            double release = vapeDevice.getVapeJuiceReleasePerTick(itemStack);

            vapeDevice.setVapeJuiceLeft(itemStack, left - use);

            Potion potion = vapeDevice.getVapeJuicePotion(itemStack);

            if (!potion.getEffects().isEmpty()) {
                for (MobEffectInstance effect : potion.getEffects()) {
                    MobEffectInstance instance = livingEntity.getEffect(effect.getEffect());
                    int releaseTicks = (int)Math.ceil(effect.getDuration() * release);
                    double additionalUsage = use * (1.0 / releaseTicks);
                    vapeDevice.setVapeJuiceLeft(itemStack, Math.max(0.0, vapeDevice.getVapeJuiceLeft(itemStack) - additionalUsage));
                    if (instance != null && instance.getAmplifier() == effect.getAmplifier()) {
                        livingEntity.addEffect(new MobEffectInstance(effect.getEffect(), instance.getDuration() + releaseTicks, effect.getAmplifier()));
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(effect.getEffect(), releaseTicks, effect.getAmplifier()));
                    }
                }
            }
        }

        if (tickIn > 80 && tickIn % 5 == 0) {
            livingEntity.hurt(VapeDamageTypes.vapeChoke(level), 1.f);
        }
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemStack) {
        return 300;
    }

    public int getTicksVaped(ItemStack itemStack, int ticksLeft) {
        return getUseDuration(itemStack) - ticksLeft;
    }

    @Override
    public void releaseUsing(@NotNull ItemStack itemStack, Level level, LivingEntity livingEntity, int tick) {
        Vec3 eyePos = livingEntity.getEyePosition();

        int ticksVaped = this.getTicksVaped(itemStack, tick);

        level.playSound(null, eyePos.x, eyePos.y, eyePos.z, VapeSoundEvents.EXHALE, SoundSource.PLAYERS, 0.3f, 1.f);

        if (level.isClientSide) {
            StoppableSoundManager.stopSound(livingEntity.getId());
        } else {
            for (Player otherPlayer : level.players()) {
                if (otherPlayer == livingEntity) {
                    continue;
                }

                if (livingEntity.distanceTo(otherPlayer) > 16.0) {
                    continue;
                }

                if (otherPlayer instanceof ServerPlayer otherServerPlayer) {
                    PacketManager.instance.sendStopStoppableSound(otherServerPlayer, livingEntity);
                }
            }
        }

        itemStack.hurtAndBreak(1, livingEntity, (e) -> e.broadcastBreakEvent(livingEntity.getItemInHand(InteractionHand.OFF_HAND) == itemStack ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND));

        int smoking = EnchantmentHelper.getItemEnchantmentLevel(VapeEnchantments.SMOKING, itemStack);

        if (itemStack.getItem() instanceof IVapeDevice vapeDevice && level instanceof ServerLevel serverLevel) {
            for (int i = 0; i < Math.min(10, ticksVaped / Math.max(1, 5 - smoking)); i++) {
                TickDelayedCalls.addDelayedCall(i * 2, () -> {
                    Vec3 currentEyePos = livingEntity.getEyePosition();
                    for (int j = 0; j < 2 + 2 * smoking; j++) {
                        serverLevel.sendParticles(new VapeParticleOption(vapeDevice.getVapeJuicePotion(itemStack), smoking * 20), currentEyePos.x, currentEyePos.y, currentEyePos.z, 0, livingEntity.getLookAngle().x * 0.3, livingEntity.getLookAngle().y * 0.3, livingEntity.getLookAngle().z * 0.3, 1.0);
                    }
                });
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.addAll(getInfo(itemStack));
    }

    @Override
    public double getVapeJuiceUsagePerTick(ItemStack itemStack) {
        int economical = EnchantmentHelper.getItemEnchantmentLevel(VapeEnchantments.ECONOMICAL, itemStack);
        return Math.max(0, 0.0015 - economical * 0.0002);
    }

    @Override
    public double getVapeJuiceReleasePerTick(ItemStack itemStack) {
        int inhaling = EnchantmentHelper.getItemEnchantmentLevel(VapeEnchantments.INHALING, itemStack);
        return 0.0015 + inhaling * 0.0003;
    }

    @Override
    public boolean canReplaceJuice() {
        return true;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack itemStack, ItemStack testedItem) {
        return testedItem.is(Items.IRON_INGOT);
    }
}
