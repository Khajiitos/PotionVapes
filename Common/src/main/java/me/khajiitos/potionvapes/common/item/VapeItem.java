package me.khajiitos.potionvapes.common.item;

import me.khajiitos.potionvapes.common.VapeDamageTypes;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import me.khajiitos.potionvapes.common.stuff.VapeSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VapeItem extends Item implements IVapeDevice {
    public VapeItem(int durability) {
        super(new Item.Properties().stacksTo(1).durability(durability));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }

    public static final Map<Player, SoundInstance> vapeSounds = new HashMap<>();

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (player.isUnderWater() && !player.hasEffect(MobEffects.WATER_BREATHING)) {
            return InteractionResultHolder.consume(itemStack);
        }

        if (getVapeJuiceLeft(itemStack) <= 0) {
            return InteractionResultHolder.fail(itemStack);
        }

        player.startUsingItem(interactionHand);

        if (vapeSounds.containsKey(player)) {
            Minecraft.getInstance().getSoundManager().stop(vapeSounds.get(player));
        }

        SoundInstance soundInstance = new SimpleSoundInstance(VapeSoundEvents.VAPE, SoundSource.PLAYERS, 0.75f, 1.f, player.getRandom(), player.getOnPos().above(2));
        Minecraft.getInstance().getSoundManager().play(soundInstance);
        vapeSounds.put(player, soundInstance);

        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int tick) {
        int tickIn = getUseDuration(itemStack) - tick;

        if (itemStack.getItem() instanceof IVapeDevice vapeDevice) {
            double left = vapeDevice.getVapeJuiceLeft(itemStack);
            double use = vapeDevice.getVapeJuiceUsagePerTick(itemStack);

            if (left <= use) {
                vapeDevice.emptyVapeJuice(itemStack);
                livingEntity.stopUsingItem();
            }

            vapeDevice.setVapeJuiceLeft(itemStack, left - use);

            Potion potion = vapeDevice.getVapeJuicePotion(itemStack);

            double release = vapeDevice.getVapeJuiceReleasePerTick(itemStack);

            if (!potion.getEffects().isEmpty()) {
                for (MobEffectInstance effect : potion.getEffects()) {
                    MobEffectInstance instance = livingEntity.getEffect(effect.getEffect());
                    if (instance != null && instance.getAmplifier() == effect.getAmplifier()) {
                        livingEntity.addEffect(new MobEffectInstance(effect.getEffect(), (int)(instance.getDuration() + release * effect.getDuration()), effect.getAmplifier()));
                    } else {
                        livingEntity.addEffect(new MobEffectInstance(effect.getEffect(), (int)(release * effect.getDuration()), effect.getAmplifier()));
                    }
                }
            }
        }

        if (tickIn > 80 && tickIn % 5 == 0) {
            livingEntity.hurt(VapeDamageTypes.vapeChoke(level), 1.f);
        }
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 300;
    }

    public int getTicksVaped(ItemStack itemStack, int ticksLeft) {
        return getUseDuration(itemStack) - ticksLeft;
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int tick) {
        Vec3 eyePos = livingEntity.getEyePosition();

        int ticksVaped = this.getTicksVaped(itemStack, tick);

        level.playSound(null, eyePos.x, eyePos.y, eyePos.z, VapeSoundEvents.EXHALE, SoundSource.PLAYERS, 0.3f, 1.f);

        // FIXME: client-side code; use packets or something
        if (livingEntity instanceof Player player && vapeSounds.containsKey(livingEntity)) {
            Minecraft.getInstance().getSoundManager().stop(vapeSounds.get(player));
            vapeSounds.remove(player);
        }

        for (int i = 0; i < ticksVaped / 5; i++) {
            level.addParticle(VapeParticles.VAPE_SMOKE, true, eyePos.x, eyePos.y, eyePos.z, livingEntity.getLookAngle().x * 0.3, livingEntity.getLookAngle().y * 0.3 + 0.1, livingEntity.getLookAngle().z * 0.3);
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.addAll(getInfo(itemStack));
    }

    @Override
    public double getVapeJuiceUsagePerTick(ItemStack itemStack) {
        // TODO: consider enchantments
        return 0.001;
    }

    @Override
    public double getVapeJuiceReleasePerTick(ItemStack itemStack) {
        // TODO: consider enchantments
        return 0.00125;
    }
}
