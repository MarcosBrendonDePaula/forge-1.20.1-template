package com.yourname.yourmodid;

import com.mojang.logging.LogUtils;
import com.yourname.yourmodid.client.renderer.entity.ExampleMobRenderer; // Import renderer
import com.yourname.yourmodid.common.entity.ExampleMobEntity;
import com.yourname.yourmodid.core.init.BlockInit;
import com.yourname.yourmodid.core.init.CreativeTabInit;
import com.yourname.yourmodid.core.init.EntityInit;
import com.yourname.yourmodid.core.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers; // Import for renderer registration
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent; // Import for attribute registration
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(YourModName.MODID)
public class YourModName {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "yourmodid"; // Ensure this matches mod_id in gradle.properties and mods.toml
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public YourModName() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Registers
        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        CreativeTabInit.CREATIVE_MODE_TABS.register(modEventBus);
        EntityInit.ENTITY_TYPES.register(modEventBus); // Register Entity Types

        // Register the entity attribute creation listener
        modEventBus.addListener(this::entityAttributeEvent);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to vanilla creative tabs event listener
        modEventBus.addListener(this::addItemsToVanillaCreativeTabs);

        // Register config (if using Forge Config)
        // FMLJavaModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP FOR {}!", MODID);
        // Common setup like registering capabilities or packet handlers would go here
        // Entity attribute registration is now handled by the EntityAttributeCreationEvent
    }

    // Listener for Entity Attribute Creation
    private void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityInit.EXAMPLE_MOB.get(), ExampleMobEntity.createAttributes().build());
        // Register attributes for other custom entities here
    }

    // Example of adding items to existing vanilla tabs
    private void addItemsToVanillaCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.EXAMPLE_PICKAXE.get());
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ItemInit.EXAMPLE_FOOD.get());
        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ItemInit.EXAMPLE_MOB_SPAWN_EGG.get()); // Add spawn egg to vanilla tab
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting for {}!", MODID);
    }

    // Client-specific setup
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP FOR {}!", MODID);
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            // Register Entity Renderers
            EntityRenderers.register(EntityInit.EXAMPLE_MOB.get(), ExampleMobRenderer::new);
            // Register renderers for other custom entities here
        }
    }
}

