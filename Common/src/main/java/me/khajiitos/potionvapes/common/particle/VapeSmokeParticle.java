package me.khajiitos.potionvapes.common.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class VapeSmokeParticle extends WhiteAshParticle {
    protected VapeSmokeParticle(ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int color, float whatever, SpriteSet sprites) {
        super(level, x, y, z, velocityX, velocityY, velocityZ, whatever, sprites);
        this.rCol = ((color & 0x00FF0000) >> 16) / 255.f;
        this.gCol = ((color & 0x0000FF00) >> 8) / 255.f;
        this.bCol = (color & 0x000000FF) / 255.f;
        this.friction = 0.96F;
        this.hasPhysics = true;
        this.lifetime = (int)((level.random.nextFloat() * 0.8 + 0.2) * 60);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet $$0) {
            this.sprite = $$0;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return createParticle(particleType, level, x, y, z, velocityX, velocityY, velocityZ, 0xFFFFFFFF);
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level, double x, double y, double z, double velocityX, double velocityY, double velocityZ, int color) {
            VapeSmokeParticle $$8 = new VapeSmokeParticle(level, x, y, z, velocityX, velocityY, velocityZ, color, 1.f, this.sprite);
            $$8.pickSprite(this.sprite);
            return $$8;
        }
    }
}
