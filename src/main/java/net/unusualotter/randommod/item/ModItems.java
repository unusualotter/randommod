package net.unusualotter.randommod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unusualotter.randommod.RandomMod;

public class ModItems {
    public static final Item BLAZING_SWORD = registerItem("blazing_sword",
            new SwordItem(newToolMaterial(500, 3, 2, 0, 20, Ingredient.ofItems(Items.BLAZE_ROD)), 4, 1.3f, new FabricItemSettings().group(ItemGroup.COMBAT)));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(RandomMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RandomMod.LOGGER.info("Items Registered");
    }
    public static ToolMaterial newToolMaterial(int durability, float miningSpeedMultiplier, float attackDamage, int miningLevel, int enchantability, Ingredient repairIngredient) {
        return new ToolMaterial() {
            @Override
            public int getDurability() {
                return durability;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return miningSpeedMultiplier;
            }

            @Override
            public float getAttackDamage() {
                return attackDamage;
            }

            @Override
            public int getMiningLevel() {
                return miningLevel;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return repairIngredient;
            }
        };
    }
}