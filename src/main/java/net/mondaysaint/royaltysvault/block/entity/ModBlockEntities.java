package net.mondaysaint.royaltysvault.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import net.mondaysaint.royaltysvault.block.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<RunicImbuerBlockEntity> RUNIC_IMBUER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(RoyaltySVault.MOD_ID, "runicimbuerbe"),
                    FabricBlockEntityTypeBuilder.create(RunicImbuerBlockEntity::new,
                            ModBlocks.RunicImbuer).build());
    public static void registerBlockEntities() {
        RoyaltySVault.LOGGER.info("Registering Block Entities for Royalty's Vault");
    }
}
