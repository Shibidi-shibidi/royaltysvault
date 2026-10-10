package net.mondaysaint.royaltysvault.Effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ChosenEffect extends StatusEffect {
    public ChosenEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFFD700);
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
        if (!entity.getWorld().isClient() && entity.getHealth() < entity.getMaxHealth()) {
            entity.heal(2.0F);
        }
    }
}
