package cji.makeitboom.world.entity;

import cji.makeitboom.MakeItBoom;
import cji.makeitboom.world.entity.projectile.BoomArrow;
import cji.makeitboom.world.entity.projectile.BoomArrowPlusOne;
import cji.makeitboom.world.entity.projectile.BoomArrowPlusTwo;
import cji.makeitboom.world.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MakeItBoom.MODID);

//    public static final EntityType<Arrow> ARROW =
//            register("arrow",
//                    EntityType.Builder.<Arrow>of(Arrow::new, MobCategory.MISC)
//                            .sized(0.5F, 0.5F)
//                            .clientTrackingRange(4)
//                            .updateInterval(20)
//            );

    public static final RegistryObject<EntityType<BoomArrow>> BOOM_ARROW =
            ENTITIES.register("boom_arrow",
                    () -> EntityType.Builder.<BoomArrow>of(BoomArrow::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(new ResourceLocation(MakeItBoom.MODID, "boom_arrow").toString()));

    public static final RegistryObject<EntityType<BoomArrowPlusOne>> BOOM_ARROW_PLUS_ONE =
            ENTITIES.register("boom_arrow_plus_one",
                    () -> EntityType.Builder.<BoomArrowPlusOne>of(BoomArrowPlusOne::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(new ResourceLocation(MakeItBoom.MODID, "boom_arrow_plus_one").toString()));

    public static final RegistryObject<EntityType<BoomArrowPlusTwo>> BOOM_ARROW_PLUS_TWO =
            ENTITIES.register("boom_arrow_plus_two",
                    () -> EntityType.Builder.<BoomArrowPlusTwo>of(BoomArrowPlusTwo::new, MobCategory.MISC)
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(new ResourceLocation(MakeItBoom.MODID, "boom_arrow_plus_two").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

}
