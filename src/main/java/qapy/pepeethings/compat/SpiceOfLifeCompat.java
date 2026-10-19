package qapy.pepeethings.compat;

import net.fabricmc.loader.api.FabricLoader;
import qapy.pepeethings.ModItems;
import qapy.spiceoflife.util.SuperFoodsRegistry;

import static qapy.pepeethings.PepeeThingsMod.LOGGER;

public class SpiceOfLifeCompat {
	private static final boolean spiceOfLifeLoaded = FabricLoader.getInstance().isModLoaded("spiceoflife");
	public static void addSpiceOfLifeCompat(){
		if(spiceOfLifeLoaded) {
			SuperFoodsRegistry.addSuperFood(ModItems.CARROT_IRON);
			LOGGER.info("Spice of Life: BTA! Edition detected.");
		}
	}
}
