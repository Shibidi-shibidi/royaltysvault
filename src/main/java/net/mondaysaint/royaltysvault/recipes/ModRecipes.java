package net.mondaysaint.royaltysvault.recipes;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.RoyaltySVault;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(RoyaltySVault.MOD_ID, RunicRecipes.Serializer.ID),
                RunicRecipes.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(RoyaltySVault.MOD_ID, RunicRecipes.Type.ID),
                RunicRecipes.Type.INSTANCE);
    }
}
