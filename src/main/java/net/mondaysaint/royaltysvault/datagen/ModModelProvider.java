package net.mondaysaint.royaltysvault.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.mondaysaint.royaltysvault.Item.ModItems;
import net.mondaysaint.royaltysvault.block.ModBlocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleState(ModBlocks.RunicImbuer);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VARYNGICCHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VARYNGICHELM));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VARYNGICBOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VARYNGICLEGGINGS));
        itemModelGenerator.register(ModItems.FERULA, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VARYNGIANSTAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VARYNGICHALBERD, Models.HANDHELD);



        itemModelGenerator.register(ModItems.PRINCESSSCEPTER, Models.HANDHELD);



    }
}
