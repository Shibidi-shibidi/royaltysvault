package net.mondaysaint.royaltysvault.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import net.mondaysaint.royaltysvault.block.custom.RunicImbuerBlock;

public class ModBlocks {
    public static final Block RunicImbuer = registerBlock("runicimbuer", new RunicImbuerBlock(FabricBlockSettings.copyOf(
            Blocks.BRAIN_CORAL
    ).nonOpaque().breakInstantly()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RoyaltySVault.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(RoyaltySVault.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        RoyaltySVault.LOGGER.info("Registering Mod Blocks for Royalty's Vault");
    }
}
