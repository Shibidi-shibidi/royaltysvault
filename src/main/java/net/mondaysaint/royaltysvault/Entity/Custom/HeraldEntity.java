package net.mondaysaint.royaltysvault.Entity.Custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.mondaysaint.royaltysvault.Entity.ModEntities;
import net.mondaysaint.royaltysvault.Item.ModItems;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class HeraldEntity extends AnimalEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public final ServerBossBar bossBar;

    public HeraldEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.setAiDisabled(false);
        this.experiencePoints = 50;
        this.bossBar = new ServerBossBar(this.getDisplayName(), BossBar.Color.RED, BossBar.Style.PROGRESS);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 400.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true, this::shouldTarget));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MobEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, SpiderEntity.class, true));
    }


    private boolean shouldTarget(LivingEntity target) {
        if (target instanceof PlayerEntity player) {
            return !isPlayerHoldingBodyOfVarys(player);
        }
        return true;
    }

    @Override
    protected void mobTick() {
        super.mobTick();


        if (this.getTarget() instanceof PlayerEntity player) {
            if (isPlayerHoldingBodyOfVarys(player)) {
                this.setTarget(null);
            }
        }
    }


    private boolean isPlayerHoldingBodyOfVarys(PlayerEntity player) {


        boolean holdingProtectedItem = player.getMainHandStack().isOf(ModItems.VARYNGICSTEEL)
                || player.getOffHandStack().isOf(ModItems.VARYNGICSTEEL);




        return holdingProtectedItem;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.HERALD.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<HeraldEntity> heraldEntityAnimationState) {
        heraldEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.herald.animation",
                Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

}
