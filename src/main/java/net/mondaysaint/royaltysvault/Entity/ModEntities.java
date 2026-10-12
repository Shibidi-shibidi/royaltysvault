package net.mondaysaint.royaltysvault.Entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Entity.Custom.HeraldEntity;
import net.mondaysaint.royaltysvault.Entity.Custom.VarysEyeEntity;
import net.mondaysaint.royaltysvault.RoyaltySVault;

public class ModEntities {
    public static final EntityType<HeraldEntity> HERALD = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RoyaltySVault.MOD_ID, "herald"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HeraldEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 3.0f))
                    .build()
    );

    public static final EntityType<VarysEyeEntity> EYE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(RoyaltySVault.MOD_ID, "eye"),
            FabricEntityTypeBuilder.<VarysEyeEntity>create(SpawnGroup.MISC, VarysEyeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .fireImmune()
                    .build()
    );
}
