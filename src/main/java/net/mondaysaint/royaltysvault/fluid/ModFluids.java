package net.mondaysaint.royaltysvault.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Item.ModItemGroups;
import net.mondaysaint.royaltysvault.RoyaltySVault;

public class ModFluids {
    public static FlowableFluid STILL_BILE;
    public static FlowableFluid FLOWING_BILE;
    public static Block BILE_BLOCk;
    public static Item BILE_BUCKET;

    public static void register() {
        STILL_BILE = Registry.register(Registries.FLUID,
                new Identifier(RoyaltySVault.MOD_ID, "still_bile"), new BileFluid.Still());
        FLOWING_BILE = Registry.register(Registries.FLUID,
                new Identifier(RoyaltySVault.MOD_ID, "flowing_bile"), new BileFluid.Flowing());

        BILE_BLOCk = Registry.register(Registries.BLOCK, new Identifier(RoyaltySVault.MOD_ID, "bile_block"),
                new FluidBlock(ModFluids.STILL_BILE, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        BILE_BUCKET = Registry.register(Registries.ITEM, new Identifier(RoyaltySVault.MOD_ID, "bile_bucket"),
                new BucketItem(ModFluids.STILL_BILE, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
