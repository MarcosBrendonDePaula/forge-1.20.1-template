package com.yourname.yourmodid.common.entity;

import com.yourname.yourmodid.core.init.EntityInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ExampleMobEntity extends Animal {

    // Constructor
    public ExampleMobEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    // Register AI Goals (Basic AI)
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this)); // Goal to swim if in water
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D)); // Goal to panic and run if attacked
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D)); // Goal to wander around randomly, avoiding water
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F)); // Goal to look at nearby players
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this)); // Goal to randomly look around
        // Add more complex goals like TemptGoal (following player with item), BreedGoal, FollowParentGoal etc. later if needed
    }

    // Define Mob Attributes (Health, Speed, etc.)
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D) // Example: 10 health (5 hearts)
                .add(Attributes.MOVEMENT_SPEED, 0.25D); // Example: Slightly faster than default passive mobs
                // Add other attributes like ATTACK_DAMAGE if it's a hostile mob
    }

    // Handle Breeding (if applicable)
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        // Return a new instance of your mob for breeding
        // return EntityInit.EXAMPLE_MOB.get().create(pLevel);
        return null; // Return null if breeding is not implemented for this example
    }

    // Add custom sounds, loot tables, etc. here later
}

