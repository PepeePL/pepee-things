package qapy.pepeethings.util;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import qapy.pepeethings.ModBlocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MossRegistry {
	private static final Map<Block<?>, Block<?>> MOSSY_MAP = new HashMap<>();
	static {
		MOSSY_MAP.put(Blocks.STONE, Blocks.MOSS_STONE);
		MOSSY_MAP.put(Blocks.COBBLE_STONE, Blocks.COBBLE_STONE_MOSSY);
		MOSSY_MAP.put(Blocks.BASALT, Blocks.MOSS_BASALT);
		MOSSY_MAP.put(Blocks.GRANITE, Blocks.MOSS_GRANITE);
		MOSSY_MAP.put(Blocks.LIMESTONE, Blocks.MOSS_LIMESTONE);
		MOSSY_MAP.put(Blocks.BRICK_STONE_POLISHED, Blocks.BRICK_STONE_POLISHED_MOSSY);
		MOSSY_MAP.put(Blocks.LOG_OAK, Blocks.LOG_OAK_MOSSY);
		MOSSY_MAP.put(Blocks.BRICK_CLAY, ModBlocks.BRICK_CLAY_MOSSY);
		MOSSY_MAP.put(ModBlocks.BRICK_CLAY_BLACK, ModBlocks.BRICK_CLAY_BLACK_MOSSY);
		MOSSY_MAP.put(ModBlocks.BRICK_CLAY_BLUE, ModBlocks.BRICK_CLAY_BLUE_MOSSY);
		MOSSY_MAP.put(ModBlocks.BRICK_CLAY_RED, ModBlocks.BRICK_CLAY_RED_MOSSY);
		MOSSY_MAP.put(ModBlocks.BRICK_CLAY_WHITE, ModBlocks.BRICK_CLAY_WHITE_MOSSY);
	}
	public static Block<?> getMossyVariant(Block<?> block){
		return MOSSY_MAP.get(block);
	}
	public static List<Block<?>> getMossyBlocks(){
		return new ArrayList<>(MOSSY_MAP.values());
	}
}
