package net.mondaysaint.royaltysvault.Item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.mondaysaint.royaltysvault.Effect.ModEffects;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Oblivion extends SwordItem {
    public Oblivion() {
        super(ModToolMaterial.VARYNGIAN, 3, 2f, new Settings());
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!attacker.getWorld().isClient()){
            target.addStatusEffect(new StatusEffectInstance(ModEffects.CURSED_EFFECT, 200, 0));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.royaltysvault.oblivion.tooltip.line1")
                .formatted(Formatting.GOLD));
        tooltip.add(Text.translatable("tooltip.royaltysvault.oblivion.tooltip.line2")
                .formatted(Formatting.GOLD));


        super.appendTooltip(stack, world, tooltip, context);
    }
}
