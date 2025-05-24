package com.yourname.yourmodid.core.init;

import com.yourname.yourmodid.YourModName;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    // DeferredRegister for Blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, YourModName.MODID);
    // DeferredRegister for BlockItems (associated with Blocks)
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS; // Use the same ITEMS DeferredRegister from ItemInit

    // Example Simple Block
    // Basic block with specific properties (hardness, resistance, sound)
    public static final RegistryObject<Block> EXAMPLE_BLOCK = registerBlock("example_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE) // Color on the map
                    .strength(2.0f, 3.0f) // Hardness (mining time), Resistance (explosion)
                    .sound(SoundType.STONE) // Sound played when interacting
                    .requiresCorrectToolForDrops()), // Requires the correct tool (e.g., pickaxe) to drop items
            new Item.Properties());

    // Example Block with Custom Functionality (Needs a custom Block class, not shown here yet)
    // public static final RegistryObject<Block> CUSTOM_FUNCTION_BLOCK = registerBlock("custom_function_block",
    //        () -> new CustomFunctionBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)),
    //        new Item.Properties());


    // Helper method to register a block and its corresponding BlockItem
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier, Item.Properties itemProperties) {
        RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
        return block;
    }

    // Helper method to register a block without a BlockItem (e.g., custom fluids, technical blocks)
    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }
}

