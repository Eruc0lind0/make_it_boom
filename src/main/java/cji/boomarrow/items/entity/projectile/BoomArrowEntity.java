package cji.boomarrow.items.entity.projectile;

import cji.boomarrow.items.ModItems;
import cji.boomarrow.items.entity.ModEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class BoomArrowEntity extends AbstractArrow {
    private final Item referenceItem;
    private float strength;

    public BoomArrowEntity(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.BOOM_ARROW.get();
    }

    public BoomArrowEntity(LivingEntity shooter, Level level, Item referenceItem, float strength) {
        super(ModEntityType.BOOM_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
        this.strength = strength;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        BlockPos blockPos = blockHitResult.getBlockPos();
        level.explode(this,
                blockPos.getX(),
                blockPos.getY(),
                blockPos.getZ(),
                strength,
                true,
                Explosion.BlockInteraction.DESTROY
        );
        this.discard();
    }

}
