package net.mondaysaint.royaltysvault;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mondaysaint.royaltysvault.datagen.ModItemTagProvider;
import net.mondaysaint.royaltysvault.datagen.ModModelProvider;

public class RoyaltySVaultDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModItemTagProvider::new);

		pack.addProvider(ModModelProvider::new);


	}
}
