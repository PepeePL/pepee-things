package qapy.pepeethings.util;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.Items;
import qapy.pepeethings.ModItems;

import java.util.ArrayList;
import java.util.List;

public class SeedsRegistry {
	public static final List<Item > SEEDS_LIST = new ArrayList<>();
	static {
		SEEDS_LIST.add(Items.SEEDS_WHEAT);
		SEEDS_LIST.add(ModItems.SEEDS_CARROT);
		SEEDS_LIST.add(ModItems.SEEDS_POTATO);
		SEEDS_LIST.add(ModItems.SEEDS_TOMATO);
	}
	public static Item getRandomSeed(){
		int index = (int)(Math.random() * SEEDS_LIST.size());
		return SEEDS_LIST.get(index);
	}
}
