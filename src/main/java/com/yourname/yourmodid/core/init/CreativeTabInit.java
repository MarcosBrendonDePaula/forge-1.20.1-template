package com.yourname.yourmodid.core.init;

import com.yourname.yourmodid.YourModName;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {
    // DeferredRegister for CreativeModeTabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, YourModName.MODID);

    // Example Creative Tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.yourmodid.example_tab")) // Title of the tab (requires translation key in lang file)
                    .icon(() -> new ItemStack(ItemInit.EXAMPLE_ITEM.get())) // Icon for the tab
                    .withTabsBefore(CreativeModeTabs.COMBAT) // Position relative to other tabs
                    .displayItems((parameters, output) -> {
                        // Add items and blocks to this tab here
                        output.accept(ItemInit.EXAMPLE_ITEM.get());
                        output.accept(ItemInit.EXAMPLE_FOOD.get());
                        output.accept(ItemInit.EXAMPLE_PICKAXE.get());
                        output.accept(BlockInit.EXAMPLE_BLOCK.get()); // Gets the BlockItem associated with the block
                        // Add other items/blocks from ItemInit and BlockInit as needed
                    })
                    .build());

    // You can register multiple tabs if needed

}

