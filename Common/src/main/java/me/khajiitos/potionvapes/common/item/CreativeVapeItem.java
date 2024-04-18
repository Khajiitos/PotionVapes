package me.khajiitos.potionvapes.common.item;

import me.khajiitos.potionvapes.common.PotionVapes;
import me.khajiitos.potionvapes.common.client.PotionVapesClient;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CreativeVapeItem extends VapeItem {
    public CreativeVapeItem() {
        super(-1);
    }

    @Override
    public double getVapeJuiceUsagePerTick(ItemStack itemStack) {
        return 0.0;
    }

    @Override
    public @NotNull Rarity getRarity(@NotNull ItemStack itemStack) {
        return Rarity.EPIC;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        if (level.isClientSide && player.isCrouching()) {
            // TODO: make sure this doesn't crash on the server side
            PotionVapesClient.openCreativeVapeScreen();
        }
        return super.use(level, player, interactionHand);
    }
}
