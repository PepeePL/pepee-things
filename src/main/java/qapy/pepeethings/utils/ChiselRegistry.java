package qapy.pepeethings.utils;

import net.minecraft.core.block.Blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselRegistry {
	private static final List<Map<Integer, Integer>> STAGES = new ArrayList<>();

	static {
		Map<Integer, Integer> stoneMap = new HashMap<>();
		stoneMap.put(Blocks.STONE.id(), Blocks.BRICK_STONE.id());
		stoneMap.put(Blocks.BRICK_STONE.id(), Blocks.STONE_POLISHED.id());
		stoneMap.put(Blocks.STONE_POLISHED.id(), Blocks.STONE_CARVED.id());
		stoneMap.put(Blocks.STONE_CARVED.id(), Blocks.BRICK_STONE_POLISHED.id());
		stoneMap.put(Blocks.BRICK_STONE_POLISHED.id(), Blocks.STONE.id());
		Map<Integer, Integer> limestoneMap = new HashMap<>();
		limestoneMap.put(Blocks.LIMESTONE.id(), Blocks.BRICK_LIMESTONE.id());
		limestoneMap.put(Blocks.BRICK_LIMESTONE.id(), Blocks.LIMESTONE_POLISHED.id());
		limestoneMap.put(Blocks.LIMESTONE_POLISHED.id(), Blocks.LIMESTONE_CARVED.id());
		limestoneMap.put(Blocks.LIMESTONE_CARVED.id(), Blocks.LIMESTONE.id());
		Map<Integer, Integer> basaltMap = new HashMap<>();
		basaltMap.put(Blocks.BASALT.id(), Blocks.BRICK_BASALT.id());
		basaltMap.put(Blocks.BRICK_BASALT.id(), Blocks.BASALT_POLISHED.id());
		basaltMap.put(Blocks.BASALT_POLISHED.id(), Blocks.BASALT_CARVED.id());
		basaltMap.put(Blocks.BASALT_CARVED.id(), Blocks.BASALT.id());
		Map<Integer, Integer> graniteMap = new HashMap<>();
		graniteMap.put(Blocks.GRANITE.id(), Blocks.BRICK_GRANITE.id());
		graniteMap.put(Blocks.BRICK_GRANITE.id(), Blocks.GRANITE_POLISHED.id());
		graniteMap.put(Blocks.GRANITE_POLISHED.id(), Blocks.GRANITE_CARVED.id());
		graniteMap.put(Blocks.GRANITE_CARVED.id(), Blocks.GRANITE.id());
		Map<Integer, Integer> slateMap = new HashMap<>();
		slateMap.put(Blocks.SLATE.id(), Blocks.BRICK_SLATE.id());
		slateMap.put(Blocks.BRICK_SLATE.id(), Blocks.SLATE_POLISHED.id());
		slateMap.put(Blocks.SLATE_POLISHED.id(), Blocks.SLATE.id());
		Map<Integer, Integer> netherrackMap = new HashMap<>();
		netherrackMap.put(Blocks.NETHERRACK.id(), Blocks.BRICK_NETHERRACK.id());
		netherrackMap.put(Blocks.BRICK_NETHERRACK.id(), Blocks.NETHERRACK_POLISHED.id());
		netherrackMap.put(Blocks.NETHERRACK_POLISHED.id(), Blocks.NETHERRACK_CARVED.id());
		netherrackMap.put(Blocks.NETHERRACK_CARVED.id(), Blocks.NETHERRACK.id());
		Map<Integer, Integer> permafrostMap = new HashMap<>();
		permafrostMap.put(Blocks.PERMAFROST.id(), Blocks.BRICK_PERMAFROST.id());
		permafrostMap.put(Blocks.BRICK_PERMAFROST.id(), Blocks.PERMAFROST_POLISHED.id());
		permafrostMap.put(Blocks.PERMAFROST_POLISHED.id(), Blocks.PERMAFROST_CARVED.id());
		permafrostMap.put(Blocks.PERMAFROST_CARVED.id(), Blocks.PERMAFROST.id());
		Map<Integer, Integer> marbleMap = new HashMap<>();
		marbleMap.put(Blocks.MARBLE.id(), Blocks.PILLAR_MARBLE.id());
		marbleMap.put(Blocks.PILLAR_MARBLE.id(), Blocks.BRICK_MARBLE.id());
		marbleMap.put(Blocks.BRICK_MARBLE.id(), Blocks.CAPSTONE_MARBLE.id());
		marbleMap.put(Blocks.CAPSTONE_MARBLE.id(), Blocks.MARBLE.id());
		Map<Integer, Integer> sandstoneMap = new HashMap<>();
		sandstoneMap.put(Blocks.SANDSTONE.id(), Blocks.BRICK_SANDSTONE.id());
		sandstoneMap.put(Blocks.BRICK_SANDSTONE.id(), Blocks.SANDSTONE.id());
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
	public static Integer getNext(int blockId) {
		for (Map<Integer, Integer> matMap : STAGES) {
			Integer next = matMap.get(blockId);
			if (next != null) {
				return next;
			}
		}
		return null;
	}
}
