package qapy.pepeethings;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import qapy.pepeethings.items.Chisel;
import qapy.pepeethings.items.ItemToolHammer;
import qapy.pepeethings.items.Moss;
import qapy.pepeethings.items.SteelChisel;
import turniplabs.halplibe.helper.ItemBuilder;

import static qapy.pepeethings.ModConfig.itemID;
import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModItems {
	public static Item CHISEL;
	public static Item CHISEL_STEEL;
	public static Item MOSS;
	public static Item TOOL_HAMMER_STONE;
	public static Item TOOL_HAMMER_IRON;
	public static Item TOOL_HAMMER_GOLD;
	public static Item TOOL_HAMMER_DIAMOND;
	public static Item TOOL_HAMMER_STEEL;


	public void initItems(){
		CHISEL = new ItemBuilder(MOD_ID)
			.build(new Chisel("chisel", "pepeethings:item/chisel", itemID("CHISEL")));
		CHISEL_STEEL = new ItemBuilder(MOD_ID)
			.build(new SteelChisel("chisel.steel", "pepeethings:item/chisel_steel", itemID("CHISEL_STEEL")));
		MOSS = new ItemBuilder(MOD_ID)
			.build(new Moss("moss", "pepeethings:item/moss", itemID("MOSS")));
		TOOL_HAMMER_STONE = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.stone", "pepeethings:item/tool_hammer_stone", itemID("TOOL_HAMMER_STONE"), ToolMaterial.stone));
		TOOL_HAMMER_IRON = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.iron", "pepeethings:item/tool_hammer_iron", itemID("TOOL_HAMMER_IRON"), ToolMaterial.iron));
		TOOL_HAMMER_GOLD = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.gold", "pepeethings:item/tool_hammer_gold", itemID("TOOL_HAMMER_GOLD"), ToolMaterial.gold));
		TOOL_HAMMER_DIAMOND = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.diamond", "pepeethings:item/tool_hammer_diamond", itemID("TOOL_HAMMER_DIAMOND"), ToolMaterial.diamond));
		TOOL_HAMMER_STEEL = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.steel", "pepeethings:item/tool_hammer_steel", itemID("TOOL_HAMMER_STEEL"), ToolMaterial.steel));
	}
}
