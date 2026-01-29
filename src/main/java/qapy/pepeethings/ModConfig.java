package qapy.pepeethings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModConfig {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static TomlConfigHandler cfg;

	public static final String GeneralCategory = "general";

	private static int BLOCK_ID_START = 3600;
	public static int currentBlockID;
	private static int ITEM_ID_START = 30000;
	public static int currentItemID;

	static void setup(){
		LOGGER.info("Initializing Config...");

		Toml props = new Toml("pepeethings.toml");
		assembleProperties(props);
		cfg = new TomlConfigHandler(MOD_ID, props);
		if(cfg.getConfigFile().exists()) cfg.loadConfig();
		else {
			try {
				cfg.getConfigFile().createNewFile();
			} catch (Exception e){
				throw new RuntimeException(e);
			}
			cfg.writeConfig();
		}
		loadProperties();
	}
	private static void loadProperties(){
		currentBlockID = BLOCK_ID_START = cfgGetValueOrDefault(GeneralCategory + ".blockIDStart", BLOCK_ID_START);
		currentItemID = ITEM_ID_START = cfgGetValueOrDefault(GeneralCategory + ".itemIDStart", ITEM_ID_START);
	}
	private static void assembleProperties(Toml props){
		props.addCategory(GeneralCategory)
			.addEntry("blockIDStart", BLOCK_ID_START)
			.addEntry("itemIDStart", ITEM_ID_START);
	}
	public static int blockID(){
		return currentBlockID++;
	}
	public static int itemID() {
		return currentItemID++;
	}
	@SuppressWarnings("unchecked")
	static <T> T cfgGetValueOrDefault(String key, T def) {
		T res = null;

		try {
			if (def instanceof String) {
				res = (T) cfg.getString(key);
			} else if (def instanceof Integer) {
				res = (T) Integer.valueOf(cfg.getInt(key));
			} else if (def instanceof Long) {
				res = (T) Long.valueOf(cfg.getLong(key));
			} else if (def instanceof Boolean) {
				res = (T) Boolean.valueOf(cfg.getBoolean(key));
			} else if (def instanceof Double || def instanceof Float) {
				double raw = cfg.getDouble(key);

				if (def instanceof Float) res = (T) Float.valueOf((float) raw);
				else res = (T) Double.valueOf(raw);
			} else {
				throw new RuntimeException("Invalid value type!");
			}

		} catch (NullPointerException ignored) {
		}

		if (res == null) {
			LOGGER.warn("Failed to load \"{}\"! Assuming default...", key);
			return def;
		}

		return res;
	}
}
