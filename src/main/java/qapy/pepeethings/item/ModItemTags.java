package qapy.pepeethings.item;

import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.Items;
import qapy.pepeethings.ModItems;

import static net.minecraft.core.item.tag.ItemTags.TAG_LIST;

public class ModItemTags {
	public static final Tag<Item> PUTABLE_INTO_CRATE = Tag.of("pepeethings:putable_into_crate");
	static {
		PUTABLE_INTO_CRATE.tag(Items.FOOD_APPLE);
		PUTABLE_INTO_CRATE.tag(Items.WHEAT);
		PUTABLE_INTO_CRATE.tag(ModItems.CARROT);
		PUTABLE_INTO_CRATE.tag(ModItems.POTATO);
		PUTABLE_INTO_CRATE.tag(ModItems.TOMATO);

		TAG_LIST.add(PUTABLE_INTO_CRATE);
	}
}
