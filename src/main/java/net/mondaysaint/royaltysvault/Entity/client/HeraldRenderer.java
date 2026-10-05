package net.mondaysaint.royaltysvault.Entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.mondaysaint.royaltysvault.Entity.Custom.HeraldEntity;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HeraldRenderer extends GeoEntityRenderer<HeraldEntity> {


    public HeraldRenderer(EntityRendererFactory.Context context) {
        super(context, new HeraldModel());
    }

    @Override
    public Identifier getTextureLocation(HeraldEntity animatable) {
        return new Identifier(RoyaltySVault.MOD_ID, "textures/entity/herald.png");


    }
    public void render(HeraldEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight){
        poseStack.scale(5f, 5f, 5f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    }

