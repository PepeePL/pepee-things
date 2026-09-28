package qapy.pepeethings;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.sound.SoundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class PepeeThingsClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitializeClient() {
		ClientEvents.BEFORE_CLIENT_START.listen(Key.of(MOD_ID), this::beforeClientStart);
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID),(t)->new PepeeThingsModels().initBlockModels(t));
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID),(t)->new PepeeThingsModels().initItemModels(t));
		ClientEvents.BLOCK_COLOR_RELOAD.listen(Key.of(MOD_ID),(t)->new PepeeThingsModels().initBlockColors(t));
		ClientEvents.ENTITY_RENDERER_RELOAD.listen(Key.of(MOD_ID),(t)->new PepeeThingsModels().initEntityModels(t));
	}
	public void beforeClientStart() {
		SoundRepository.namespaceAdded(MOD_ID);
	}
}
