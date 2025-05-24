package com.yourname.yourmodid.core.init;

import com.yourname.yourmodid.YourModName;
import com.yourname.yourmodid.common.entity.ExampleMobEntity; // Placeholder for your custom entity class
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    // DeferredRegister for EntityTypes
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, YourModName.MODID);

    // Example Custom Mob Entity Type
    // Requires a custom Entity class (e.g., ExampleMobEntity)
    // .sized(width, height) defines the entity's hitbox size
    // .clientTrackingRange() / .updateInterval() / .setShouldReceiveVelocityUpdates() are important for multiplayer sync
    public static final RegistryObject<EntityType<ExampleMobEntity>> EXAMPLE_MOB = ENTITY_TYPES.register("example_mob",
            () -> EntityType.Builder.of(ExampleMobEntity::new, MobCategory.CREATURE) // MobCategory: CREATURE, MONSTER, AMBIENT, WATER_CREATURE, etc.
                    .sized(0.8f, 0.6f) // Example size (width, height)
                    .build(YourModName.MODID + ":example_mob")); // Build with the registry name

    // Register more entity types here if needed
}

