package net.unusualotter.randommod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unusualotter.randommod.RandomMod;

public class ModBlocks {
    public static final Block MANA_TOUCHED_GOLD = registerBlock("mana-touched_gold",
            new Block(FabricBlockSettings.of(Material.STONE).hardness(3f).strength(4f).requiresTool()),ItemGroup.BUILDING_BLOCKS);
    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(RandomMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }



    public static void registerModBlocks() {

    }
}
