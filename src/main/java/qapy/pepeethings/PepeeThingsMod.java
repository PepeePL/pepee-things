package qapy.pepeethings;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.sound.SoundRepository;
import net.minecraft.core.sound.SoundTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class PepeeThingsMod implements ModInitializer, GameStartEntrypoint, ClientStartEntrypoint {
	public static final String MOD_ID = "pepeethings";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Pepee Things initialized.");
		ModConfig.setup();
	}

	@Override
	public void beforeGameStart() {
		SoundTypes.loadSoundsJson(MOD_ID);
		new ModBlocks().initBlocks();
		new ModItems().initItems();
	}

	@Override
	public void afterGameStart() {}

	@Override
	public void beforeClientStart() {
		SoundRepository.registerNamespace(MOD_ID);
	}

	@Override
	public void afterClientStart() {
	}
}
