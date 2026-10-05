package net.mondaysaint.royaltysvault.Effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect CHOSEN_EFFECT = new ChosenEffect()

            .addAttributeModifier(
                    EntityAttributes.GENERIC_MAX_HEALTH,
                    "c5e3d749-2b81-4b1a-8cfa-51a89bb613ef",
                    20.0D,
                    EntityAttributeModifier.Operation.ADDITION
            )

            .addAttributeModifier(
                    EntityAttributes.GENERIC_ATTACK_DAMAGE,
                    "4f9d8630-3b4e-47ff-99ef-87b61f8a846c",
                    4.0D,
                    EntityAttributeModifier.Operation.ADDITION
            );

    public static void registerEffects() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("royaltysvault", "chosen"), CHOSEN_EFFECT);
    }
}
