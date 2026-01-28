package qapy.pepeethings.utils;

import net.minecraft.core.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MossRegistry {
	private static final Map<Integer, Integer> MOSSY_MAP = new HashMap<>();
	static {
		MOSSY_MAP.put(Blocks.STONE.id(), Blocks.MOSS_STONE.id());
		MOSSY_MAP.put(Blocks.COBBLE_STONE.id(), Blocks.COBBLE_STONE_MOSSY.id());
		MOSSY_MAP.put(Blocks.BASALT.id(), Blocks.MOSS_BASALT.id());
		MOSSY_MAP.put(Blocks.GRANITE.id(), Blocks.MOSS_GRANITE.id());
		MOSSY_MAP.put(Blocks.LIMESTONE.id(), Blocks.MOSS_LIMESTONE.id());
		MOSSY_MAP.put(Blocks.BRICK_STONE_POLISHED.id(), Blocks.BRICK_STONE_POLISHED_MOSSY.id());
		MOSSY_MAP.put(Blocks.LOG_OAK.id(), Blocks.LOG_OAK_MOSSY.id());
	}
	public static Integer getMossyVariant(int blockID){
		return MOSSY_MAP.get(blockID);
	}
	public static List<Integer> getMossyBlocks(){
		return new ArrayList<>(MOSSY_MAP.values());
	}
}
