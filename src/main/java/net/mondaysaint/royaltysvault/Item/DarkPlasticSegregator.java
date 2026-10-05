package net.mondaysaint.royaltysvault.Item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkPlasticSegregator extends Item {
    public DarkPlasticSegregator(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.royaltysvault.segregator.tooltip.line1"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
