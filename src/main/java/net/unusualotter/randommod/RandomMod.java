package net.unusualotter.randommod;

import net.fabricmc.api.ModInitializer;
import net.unusualotter.randommod.block.ModBlocks;
import net.unusualotter.randommod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomMod implements ModInitializer {
	public static final String MOD_ID= "randommod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		GeckoLib.initialize();
	}
}
