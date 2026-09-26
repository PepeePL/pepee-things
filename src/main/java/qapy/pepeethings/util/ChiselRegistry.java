package qapy.pepeethings.util;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselRegistry {
	private static final List<Map<Block<?>, Block<?>>> STAGES = new ArrayList<>();

	static {
		Map<Block<?>, Block<?>> stoneMap = new HashMap<>();
		stoneMap.put(Blocks.STONE, Blocks.BRICK_STONE);
		stoneMap.put(Blocks.BRICK_STONE, Blocks.STONE_POLISHED);
		stoneMap.put(Blocks.STONE_POLISHED, Blocks.STONE_CARVED);
		stoneMap.put(Blocks.STONE_CARVED, Blocks.BRICK_STONE_POLISHED);
		stoneMap.put(Blocks.BRICK_STONE_POLISHED, Blocks.STONE);
		Map<Block<?>, Block<?>> limestoneMap = new HashMap<>();
		limestoneMap.put(Blocks.LIMESTONE, Blocks.BRICK_LIMESTONE);
		limestoneMap.put(Blocks.BRICK_LIMESTONE, Blocks.LIMESTONE_POLISHED);
		limestoneMap.put(Blocks.LIMESTONE_POLISHED, Blocks.LIMESTONE_CARVED);
		limestoneMap.put(Blocks.LIMESTONE_CARVED, Blocks.LIMESTONE);
		Map<Block<?>, Block<?>> basaltMap = new HashMap<>();
		basaltMap.put(Blocks.BASALT, Blocks.BRICK_BASALT);
		basaltMap.put(Blocks.BRICK_BASALT, Blocks.BASALT_POLISHED);
		basaltMap.put(Blocks.BASALT_POLISHED, Blocks.BASALT_CARVED);
		basaltMap.put(Blocks.BASALT_CARVED, Blocks.BASALT);
		Map<Block<?>, Block<?>> graniteMap = new HashMap<>();
		graniteMap.put(Blocks.GRANITE, Blocks.BRICK_GRANITE);
		graniteMap.put(Blocks.BRICK_GRANITE, Blocks.GRANITE_POLISHED);
		graniteMap.put(Blocks.GRANITE_POLISHED, Blocks.GRANITE_CARVED);
		graniteMap.put(Blocks.GRANITE_CARVED, Blocks.GRANITE);
		Map<Block<?>, Block<?>> slateMap = new HashMap<>();
		slateMap.put(Blocks.SLATE, Blocks.BRICK_SLATE);
		slateMap.put(Blocks.BRICK_SLATE, Blocks.SLATE_POLISHED);
		slateMap.put(Blocks.SLATE_POLISHED, Blocks.SLATE);
		Map<Block<?>, Block<?>> netherrackMap = new HashMap<>();
		netherrackMap.put(Blocks.NETHERRACK, Blocks.BRICK_NETHERRACK);
		netherrackMap.put(Blocks.BRICK_NETHERRACK, Blocks.NETHERRACK_POLISHED);
		netherrackMap.put(Blocks.NETHERRACK_POLISHED, Blocks.NETHERRACK_CARVED);
		netherrackMap.put(Blocks.NETHERRACK_CARVED, Blocks.NETHERRACK);
		Map<Block<?>, Block<?>> permafrostMap = new HashMap<>();
		permafrostMap.put(Blocks.PERMAFROST, Blocks.BRICK_PERMAFROST);
		permafrostMap.put(Blocks.BRICK_PERMAFROST, Blocks.PERMAFROST_POLISHED);
		permafrostMap.put(Blocks.PERMAFROST_POLISHED, Blocks.PERMAFROST_CARVED);
		permafrostMap.put(Blocks.PERMAFROST_CARVED, Blocks.PERMAFROST);
		Map<Block<?>, Block<?>> marbleMap = new HashMap<>();
		marbleMap.put(Blocks.MARBLE, Blocks.PILLAR_MARBLE);
		marbleMap.put(Blocks.PILLAR_MARBLE, Blocks.BRICK_MARBLE);
		marbleMap.put(Blocks.BRICK_MARBLE, Blocks.CAPSTONE_MARBLE);
		marbleMap.put(Blocks.CAPSTONE_MARBLE, Blocks.MARBLE);
		Map<Block<?>, Block<?>> sandstoneMap = new HashMap<>();
		sandstoneMap.put(Blocks.SANDSTONE, Blocks.BRICK_SANDSTONE);
		sandstoneMap.put(Blocks.BRICK_SANDSTONE, Blocks.SANDSTONE);
		STAGES.add(stoneMap);
		STAGES.add(limestoneMap);
		STAGES.add(basaltMap);
		STAGES.add(graniteMap);
		STAGES.add(slateMap);
		STAGES.add(netherrackMap);
		STAGES.add(permafrostMap);
		STAGES.add(marbleMap);
		STAGES.add(sandstoneMap);

	}
	public static Block<?> getNext(Block<?> block) {
		for (Map<Block<?>, Block<?>> matMap : STAGES) {
			Block<?> next = matMap.get(block);
			if (next != null) {
				return next;
			}
		}
		return null;
	}
}
