package net.mondaysaint.royaltysvault;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.Entity.client.HeraldRenderer;
import net.mondaysaint.royaltysvault.Item.ModItems;
import net.mondaysaint.royaltysvault.fluid.ModFluids;
import net.mondaysaint.royaltysvault.screen.ModScreenHandlers;
import net.mondaysaint.royaltysvault.screen.RuneImbuingScreen;

import java.util.Objects;
import java.util.UUID;

public class RoyaltysVaultClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UUID owner = UUID.fromString("9f1ad46a-c77e-4b9c-9c9f-f5d4404aefe9");
        ModelPredicateProviderRegistry.register(ModItems.OBLIVION, new Identifier("royaltysvault", "owner"),
                (stack, world, entity, seed) -> entity != null && owner.equals(entity.getUuid()) ? 1.0f : 0.0f);
        EntityRendererRegistry.register(ModEntities.HERALD, HeraldRenderer::new);
        HandledScreens.register(ModScreenHandlers.RUNE_IMBUING_SCREEN_HANDLER, RuneImbuingScreen::new);
        FluidRenderHandlerRegistry.INSTANCE.register(
                ModFluids.STILL_BILE,
                ModFluids.FLOWING_BILE,
                new SimpleFluidRenderHandler(
                        Objects.requireNonNull(Identifier.of("minecraft", "block/water_still")),
                        Objects.requireNonNull(Identifier.of("minecraft", "block/water_flow")),
                        0x89a572
                )
        );



        BlockRenderLayerMap.INSTANCE.putFluids(
                RenderLayer.getTranslucent(),
                ModFluids.STILL_BILE,
                ModFluids.FLOWING_BILE

        );
}}
