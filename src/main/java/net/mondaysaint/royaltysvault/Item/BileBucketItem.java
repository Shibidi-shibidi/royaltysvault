package net.mondaysaint.royaltysvault.Item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BileBucketItem extends BucketItem {
    public BileBucketItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.royaltysvault.bilebucket.tooltip.line1"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
