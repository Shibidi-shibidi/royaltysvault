package net.mondaysaint.royaltysvault.Entity.Custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.Item.ModItems;
import net.mondaysaint.royaltysvault.particles.ModParticles;

public class VarysEyeEntity extends ThrownItemEntity {

    public VarysEyeEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public VarysEyeEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.EYE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.EYEOFVARYS;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if (!this.getWorld().isClient()) {
            double x = this.getX();
            double y = this.getY();
            double z = this.getZ();

            if (this.getWorld() instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x, y + 1.0, z, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x - 0.25, y + 0.5, z - 0.25, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x + 0.25, y + 0.5, z - 0.25, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x - 0.25, y + 0.5, z + 0.25, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x + 0.25, y + 0.5, z + 0.25, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x - 0.5, y, z - 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x, y, z - 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x + 0.5, y, z - 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x - 0.5, y, z, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x + 0.5, y, z, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x - 0.5, y, z + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x, y, z + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
                serverWorld.spawnParticles((ParticleEffect) ModParticles.KRAKEN_PARTICLE, x + 0.5, y, z + 0.5, 1, 0.0, 0.0, 0.0, 0.0);
            }

            net.minecraft.util.math.Box damageZone = new net.minecraft.util.math.Box(
                    x - 4.0, y - 4.0, z - 4.0,
                    x + 4.0, y + 4.0, z + 4.0
            );

            java.util.List<LivingEntity> targets = this.getWorld().getEntitiesByClass(
                    LivingEntity.class, damageZone, entity -> entity != this.getOwner()
            );

            for (LivingEntity target : targets) {
                target.damage(this.getWorld().getDamageSources().explosion(this, this.getOwner()), 400.0f);
                double dx = target.getX() - x;
                double dz = target.getZ() - z;
                double dist = Math.max(0.1, Math.sqrt(dx * dx + dz * dz));
                target.setVelocity(target.getVelocity().add((dx / dist) * 1.5, 0.8, (dz / dist) * 1.5));
                target.velocityModified = true;
            }

            this.getWorld().createExplosion(
                    this, x, y, z, 1.0f, true, World.ExplosionSourceType.TNT
            );

            this.discard();
        }
    }
}
