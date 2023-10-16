package me.khajiitos.potionvapes.common.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.jetbrains.annotations.NotNull;

public class VapeParticleOption implements ParticleOptions {
    private final int color;

    public VapeParticleOption(int color) {
        this.color = color;
    }

    public VapeParticleOption(Potion potion) {
        int color = PotionUtils.getColor(potion);

        // This is made so that the particle still remains white-ish
        int potionR = ((color & 0x00FF0000) >> 16);
        int potionG = ((color & 0x0000FF00) >> 8);
        int potionB = (color & 0x000000FF);

        int r = 255 - ((255 - potionR) / 2);
        int g = 255 - ((255 - potionG) / 2);
        int b = 255 - ((255 - potionB) / 2);

        this.color = (255 << 24) | (r << 16) | (g << 8) | b;
    }

    @Override
    public @NotNull ParticleType<?> getType() {
        return VapeParticles.VAPE_SMOKE;
    }

    public int getColor() {
        return color;
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.color);
    }

    @Override
    public @NotNull String writeToString() {
        return String.valueOf(this.color);
    }

    @SuppressWarnings("deprecation")
    public static ParticleOptions.Deserializer<VapeParticleOption> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        public @NotNull VapeParticleOption fromCommand(@NotNull ParticleType<VapeParticleOption> particleType, StringReader stringReader) throws CommandSyntaxException {
            return new VapeParticleOption(stringReader.readInt());
        }

        public @NotNull VapeParticleOption fromNetwork(@NotNull ParticleType<VapeParticleOption> particleType, FriendlyByteBuf friendlyByteBuf) {
            return new VapeParticleOption(friendlyByteBuf.readInt());
        }
    };
}
