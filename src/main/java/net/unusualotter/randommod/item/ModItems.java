package net.unusualotter.randommod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unusualotter.randommod.RandomMod;

public class ModItems {
    public static final Item BLAZING_SWORD = registerItem("blazing_sword",
            new Item(new FabricItemSettings().group(ItemGroup.COMBAT)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RandomMod.LOGGER.info("Items Registered");
    }
}
