package net.mondaysaint.royaltysvault.particles;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleEffect;

import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final ParticleType KRAKEN_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(
                Registries.PARTICLE_TYPE,
                new Identifier("royaltysvault", "kraken_particle"),
                (ParticleType<?>) KRAKEN_PARTICLE
        );
    }
}
