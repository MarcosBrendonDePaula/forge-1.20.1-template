package com.yourname.yourmodid.core.init;

import com.yourname.yourmodid.YourModName;
import net.minecraft.world.food.FoodProperties;

public class FoodInit {
    // Define FoodProperties constants here for organization

    public static final FoodProperties EXAMPLE_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(5) // How many hunger points it restores (half-shanks)
            .saturationMod(0.6f) // Saturation modifier (higher means longer before hunger depletes again)
            // .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 1.0f) // Optional: Apply a potion effect (e.g., Absorption for 10 seconds) with 100% probability
            .meat() // Optional: Mark as meat (for wolf feeding, etc.)
            .fast() // Optional: Make eating faster
            .alwaysEat() // Optional: Allow eating even when full (like Golden Apples)
            .build();
}

