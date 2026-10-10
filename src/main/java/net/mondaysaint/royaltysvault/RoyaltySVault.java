package net.mondaysaint.royaltysvault;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;

import net.mondaysaint.royaltysvault.Effect.ModEffects;
import net.mondaysaint.royaltysvault.Entity.Custom.HeraldEntity;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.Item.ModItemGroups;
import net.mondaysaint.royaltysvault.Item.ModItems;
import net.mondaysaint.royaltysvault.block.ModBlocks;
import net.mondaysaint.royaltysvault.block.entity.ModBlockEntities;
import net.mondaysaint.royaltysvault.fluid.ModFluids;
import net.mondaysaint.royaltysvault.screen.ModScreenHandlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoyaltySVault implements ModInitializer {
	public static final String MOD_ID = "royaltysvault";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModFluids.register();
		ModEffects.registerEffects();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		FabricDefaultAttributeRegistry.register(ModEntities.HERALD, HeraldEntity.setAttributes());
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
