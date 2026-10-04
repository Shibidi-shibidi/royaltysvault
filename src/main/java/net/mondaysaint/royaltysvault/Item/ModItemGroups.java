package net.mondaysaint.royaltysvault.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import net.mondaysaint.royaltysvault.fluid.ModFluids;

public class ModItemGroups {
    public static final ItemGroup VARYNGIC_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RoyaltySVault.MOD_ID, "varyngic"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.varyngic"))
                    .icon(() -> new ItemStack(ModItems.VARYNGICSTEEL)
                    ).entries((displayContext, entries) -> {
                        entries.add(ModItems.OBLIVION);
                        entries.add(ModItems.VARYNGICSTEEL);
                        entries.add(ModItems.HERALD_SPAWN_EGG);
                        entries.add(ModFluids.BILE_BUCKET);
                        entries.add(ModItems.VARYNGICSILT);

                    }).build());
    public static void registerItemGroups() {
        RoyaltySVault.LOGGER.info("Registering Item Groups for " + RoyaltySVault.MOD_ID);
    }

}
