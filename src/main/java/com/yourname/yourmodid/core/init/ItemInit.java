package com.yourname.yourmodid.core.init;

import com.yourname.yourmodid.YourModName;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    // DeferredRegister for Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, YourModName.MODID);

    // Example Basic Item
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties()));

    // Example Food Item
    public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
            () -> new Item(new Item.Properties().food(FoodInit.EXAMPLE_FOOD_PROPERTIES))); // Reference FoodProperties from a separate class

    // Example Basic Tool (Pickaxe)
    public static final RegistryObject<Item> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe",
            () -> new PickaxeItem(Tiers.IRON, 1, -2.8f, new Item.Properties()));

    // Example Spawn Egg for Custom Mob
    // Colors are background and foreground (dots) in hexadecimal (0xRRGGBB)
    public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_MOB_SPAWN_EGG = ITEMS.register("example_mob_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.EXAMPLE_MOB, 0xabcdef, 0x123456, new Item.Properties()));

}

