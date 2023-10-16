package me.khajiitos.potionvapes.common.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.MenuConstructor;
import org.jetbrains.annotations.NotNull;

public class VapeSmokeParticle extends WhiteAshParticle {
    protected VapeSmokeParticle(ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int color, float whatever, SpriteSet sprites) {
        super(level, x, y, z, velocityX, velocityY, velocityZ, whatever, sprites);
        this.rCol = ((color & 0x00FF0000) >> 16) / 255.f;
        this.gCol = ((color & 0x0000FF00) >> 8) / 255.f;
        this.bCol = (color & 0x000000FF) / 255.f;
        this.friction = 0.96F;
        this.hasPhysics = true;
        this.lifetime = (int)((level.random.nextFloat() * 0.5 + 1.0) * 60);
        this.quadSize = level.random.nextFloat() * 0.2f + 0.2f;
    }
    @Override
    public void tick() {
        super.tick();
        if (this.age >= 15) {
            this.xd += level.random.nextFloat() * 0.025f - 0.0125f;
            this.yd += level.random.nextFloat() * 0.025f - 0.0125f;
            this.zd += level.random.nextFloat() * 0.025f - 0.0125f;
        }
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<VapeParticleOption> {
        private final SpriteSet sprite;

        public Provider(SpriteSet $$0) {
            this.sprite = $$0;
        }

        public Particle createParticle(@NotNull VapeParticleOption particleType, @NotNull ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return createParticle(level, x, y, z, velocityX, velocityY, velocityZ, particleType.getColor());
        }

        public Particle createParticle(ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int color) {
            VapeSmokeParticle $$8 = new VapeSmokeParticle(level, x, y, z, velocityX, velocityY, velocityZ, color, 1.f, this.sprite);
            $$8.pickSprite(this.sprite);
            return $$8;
        }
    }
}
