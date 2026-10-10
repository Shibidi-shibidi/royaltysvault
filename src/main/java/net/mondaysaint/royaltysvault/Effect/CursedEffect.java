package net.mondaysaint.royaltysvault.Effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.mondaysaint.royaltysvault.Entity.Custom.HeraldEntity;

public class CursedEffect extends StatusEffect {
    public CursedEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xff004f);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int tickInterval = 50 >> amplifier;
        if (tickInterval > 0) {
            return duration % tickInterval == 0;
        } else {
            return true;
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof HeraldEntity){
            entity.removeStatusEffect(this);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0));
            return;
        }

        if (!entity.getWorld().isClient() && entity.getHealth() < entity.getMaxHealth()) {
            entity.damage(entity.getDamageSources().magic(), 1F);
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
