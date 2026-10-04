package net.mondaysaint.royaltysvault;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.Entity.client.HeraldRenderer;
import net.mondaysaint.royaltysvault.fluid.ModFluids;

import java.util.Objects;

public class RoyaltysVaultClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.HERALD, HeraldRenderer::new);
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
