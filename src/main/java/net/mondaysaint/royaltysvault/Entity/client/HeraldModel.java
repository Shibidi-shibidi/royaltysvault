package net.mondaysaint.royaltysvault.Entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mondaysaint.royaltysvault.Entity.Custom.HeraldEntity;
import net.mondaysaint.royaltysvault.RoyaltySVault;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HeraldModel extends GeoModel<HeraldEntity> {
    @Override
    public void setCustomAnimations(HeraldEntity animatable, long instanceId, AnimationState<HeraldEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }}

    @Override
    public Identifier getModelResource(HeraldEntity animatable) {
        return new Identifier(RoyaltySVault.MOD_ID, "geo/herald.geo.json");
    }

    @Override
    public Identifier getTextureResource(HeraldEntity animatable) {
        return new Identifier(RoyaltySVault.MOD_ID, "textures/entity/herald.png");
    }

    @Override
    public Identifier getAnimationResource(HeraldEntity animatable) {
        return new Identifier(RoyaltySVault.MOD_ID, "animations/herald.animation.json");


    }
}
