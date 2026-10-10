package net.mondaysaint.royaltysvault.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VaryngicHalberd extends AxeItem {
    public VaryngicHalberd() {
        super(ModToolMaterial.VARYNGIAN, 9, -3, new FabricItemSettings());
    }



    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.royaltysvault.halberd.tooltip.line1")
                .formatted(Formatting.DARK_GREEN));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
