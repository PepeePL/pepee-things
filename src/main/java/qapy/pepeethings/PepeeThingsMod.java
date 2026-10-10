package qapy.pepeethings;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.sound.SoundTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qapy.pepeethings.block.ModBlockTags;
import qapy.pepeethings.item.ModItemTags;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.util.dependency.Key;

public class PepeeThingsMod implements ModInitializer{
	public static final String MOD_ID = HalpLibe.registerMod("pepeethings", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		CommonEvents.RECIPES_NAMESPACE_INIT.listen(Key.of(MOD_ID), PepeeThingsRecipes::initNamespaces);
		CommonEvents.RECIPES_READY.listen(Key.of(MOD_ID), PepeeThingsRecipes::onRecipesReady);
		ModConfig.setup();
		LOGGER.info("Pepee Things initialized.");
	}

	public void beforeGameStart() {
		new ModBlocks().initBlocks();
		new ModItems().initItems();
		new ModEntities().initEntities();
		SoundTypes.loadSoundsJson(MOD_ID);

	}

	public void afterGameStart() {
		new ModBlockTags();
		new ModItemTags();
	}
}
