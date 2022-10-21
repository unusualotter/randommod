package net.unusualotter.randommod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unusualotter.randommod.RandomMod;
import net.unusualotter.randommod.item.custom.BlazingSwordItem;

public class ModItems {
    public static final Item BLAZING_SWORD = registerItem("blazing_sword",
            new BlazingSwordItem(new FabricItemSettings().group(ItemGroup.COMBAT).maxDamage(1200)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RandomMod.LOGGER.info("Items Registered");
    }
}