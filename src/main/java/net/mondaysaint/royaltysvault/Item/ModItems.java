package net.mondaysaint.royaltysvault.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Effect.ModEffects;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import net.mondaysaint.royaltysvault.fluid.BileFluid;

public class ModItems {
    public static final Item VARYNGICSTEEL = registerItem("varyngicsteel", new Item(new FabricItemSettings()));
    public static final Item VARYNGICSILT = registerItem("varyngicsilt", new Item(new FabricItemSettings().food(new FoodComponent.Builder().build())));
            ;
    public static final Item DARKPLASTICSEGREGATOR = registerItem("darkplasticsegregator", new DarkPlasticSegregator(new FabricItemSettings()));

    public static final Item OBLIVION = registerItem("oblivion", new Oblivion());
    public static final Item VARYNGIANSTAFF = registerItem("varyngianstaff", new VaryngianStaff());
    public static final Item VARYNGICHALBERD = registerItem("varyngichalberd", new VaryngicHalberd());


    public static final Item FERULA = registerItem("ferula", new BowItem(new FabricItemSettings()));
    public static final Item PRINCESSSCEPTER = registerItem("princessscepter", new Princessscepter());

    public static final Item VARYNGICBOOTS = registerItem("varyngicboots", new ModArmorItem(ModArmorMaterials.VARYNGIC, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item VARYNGICHELM = registerItem("varyngichelm", new ModArmorItem(ModArmorMaterials.VARYNGIC, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item VARYNGICCHESTPLATE = registerItem("varyngicchestplate", new ModArmorItem(ModArmorMaterials.VARYNGIC, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item VARYNGICLEGGINGS = registerItem("varyngicleggings", new ModArmorItem(ModArmorMaterials.VARYNGIC, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item HERALD_SPAWN_EGG = registerItem("herald_spawn_egg",
            new SpawnEggItem(ModEntities.HERALD, 0xFFFFFF, 0xFFFFFF, new FabricItemSettings()));

    // corpse of Varys
    public static final Item EYEOFVARYS = registerItem("eyeofvarys", new EyeItem(new FabricItemSettings().food(new FoodComponent.Builder().statusEffect(new StatusEffectInstance(ModEffects.CURSED_EFFECT), 1.0f).alwaysEdible().saturationModifier(10f)
            .hunger(10).build())));




    public static void registerModItems() {
        RoyaltySVault.LOGGER.info("Registering Mod Items for " + RoyaltySVault.MOD_ID);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RoyaltySVault.MOD_ID, name), item);
    }
}