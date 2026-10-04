package net.mondaysaint.royaltysvault.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import net.mondaysaint.royaltysvault.fluid.BileFluid;

public class ModItems {
    public static final Item VARYNGICSTEEL = registerItem("varyngicsteel", new Item(new FabricItemSettings()));
    public static final Item VARYNGICSILT = registerItem("varyngicsilt", new Item(new FabricItemSettings()));
    public static final Item OBLIVION = registerItem("oblivion", new Oblivion());

    public static final Item HERALD_SPAWN_EGG = registerItem("herald_spawn_egg",
            new SpawnEggItem(ModEntities.HERALD, 0xff004f, 0x00FE62, new FabricItemSettings()));



    public static void registerModItems() {
        RoyaltySVault.LOGGER.info("Registering Mod Items for " + RoyaltySVault.MOD_ID);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RoyaltySVault.MOD_ID, name), item);
    }
}