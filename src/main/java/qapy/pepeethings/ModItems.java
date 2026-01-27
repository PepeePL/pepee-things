package qapy.pepeethings;

import net.minecraft.core.item.Item;
import qapy.pepeethings.items.Chisel;
import qapy.pepeethings.items.Moss;
import qapy.pepeethings.items.SteelChisel;
import turniplabs.halplibe.helper.ItemBuilder;

import static qapy.pepeethings.ModConfig.itemID;
import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModItems {
	public static Item CHISEL;
	public static Item CHISEL_STEEL;
	public static Item MOSS;

	public void initItems(){
		CHISEL = new ItemBuilder(MOD_ID)
			.build(new Chisel("chisel", "pepeethings:item/chisel", itemID("CHISEL")));
		CHISEL_STEEL = new ItemBuilder(MOD_ID)
			.build(new SteelChisel("chisel_steel", "pepeethings:item/chisel_steel", itemID("CHISEL_STEEL")));
		MOSS = new ItemBuilder(MOD_ID)
			.build(new Moss("moss", "pepeethings:item/moss", itemID("MOSS")));
	}
}
