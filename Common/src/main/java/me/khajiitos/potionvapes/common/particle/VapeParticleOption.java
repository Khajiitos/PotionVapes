package me.khajiitos.potionvapes.common.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.khajiitos.potionvapes.common.stuff.VapeParticles;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ShriekParticleOption;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import org.jetbrains.annotations.NotNull;

public class VapeParticleOption implements ParticleOptions {
    private final int color;
    private final int extraLength;

    public static final Codec<VapeParticleOption> CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.INT.fieldOf("color").forGetter((option) -> option.color), Codec.INT.fieldOf("extraLength").forGetter(option -> option.extraLength)).apply(instance, VapeParticleOption::new));

    public VapeParticleOption(int color, int extraLength) {
        this.color = color;
        this.extraLength = extraLength;
    }

    public VapeParticleOption(Potion potion, int extraLength) {
        int color = PotionUtils.getColor(potion);

        // This is made so that the particle still remains white-ish
        int potionR = ((color & 0x00FF0000) >> 16);
        int potionG = ((color & 0x0000FF00) >> 8);
        int potionB = (color & 0x000000FF);

        int r = 255 - ((255 - potionR) / 2);
        int g = 255 - ((255 - potionG) / 2);
        int b = 255 - ((255 - potionB) / 2);

        this.color = (255 << 24) | (r << 16) | (g << 8) | b;
        this.extraLength = extraLength;
    }

    @Override
    public @NotNull ParticleType<?> getType() {
        return VapeParticles.VAPE_SMOKE;
    }

    public int getColor() {
        return color;
    }

    public int getExtraLength() {
        return extraLength;
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.color);
        friendlyByteBuf.writeInt(this.extraLength);
    }

    @Override
    public @NotNull String writeToString() {
        return this.color + " " + this.extraLength;
    }

    @SuppressWarnings("deprecation")
    public static ParticleOptions.Deserializer<VapeParticleOption> DESERIALIZER = new ParticleOptions.Deserializer<>() {
        public @NotNull VapeParticleOption fromCommand(@NotNull ParticleType<VapeParticleOption> particleType, StringReader stringReader) throws CommandSyntaxException {
            return new VapeParticleOption(stringReader.readInt(), stringReader.readInt());
        }

        public @NotNull VapeParticleOption fromNetwork(@NotNull ParticleType<VapeParticleOption> particleType, FriendlyByteBuf friendlyByteBuf) {
            return new VapeParticleOption(friendlyByteBuf.readInt(), friendlyByteBuf.readInt());
        }
    };
}
