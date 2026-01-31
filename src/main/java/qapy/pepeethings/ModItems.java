package qapy.pepeethings;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemRope;
import net.minecraft.core.item.material.ToolMaterial;
import qapy.pepeethings.item.*;
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
	public static Item NET;
	public static Item CHAIN;


	public void initItems(){
		CHISEL = new ItemBuilder(MOD_ID)
			.build(new Chisel("chisel", "pepeethings:item/chisel", itemID()));
		CHISEL_STEEL = new ItemBuilder(MOD_ID)
			.build(new SteelChisel("chisel.steel", "pepeethings:item/chisel_steel", itemID()));
		MOSS = new ItemBuilder(MOD_ID)
			.build(new Moss("moss", "pepeethings:item/moss", itemID()));
		TOOL_HAMMER_STONE = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.stone", "pepeethings:item/tool_hammer_stone", itemID(), ToolMaterial.stone));
		TOOL_HAMMER_IRON = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.iron", "pepeethings:item/tool_hammer_iron", itemID(), ToolMaterial.iron));
		TOOL_HAMMER_GOLD = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.gold", "pepeethings:item/tool_hammer_gold", itemID(), ToolMaterial.gold));
		TOOL_HAMMER_DIAMOND = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.diamond", "pepeethings:item/tool_hammer_diamond", itemID(), ToolMaterial.diamond));
		TOOL_HAMMER_STEEL = new ItemBuilder(MOD_ID)
			.build(new ItemToolHammer("tool.hammer.steel", "pepeethings:item/tool_hammer_steel", itemID(), ToolMaterial.steel));
		NET = new ItemBuilder(MOD_ID)
			.build(new Net("net", "pepeethings:item/net", itemID()));
		CHAIN = new ItemBuilder(MOD_ID)
			.build(new ItemRope("chain", "pepeethings:item/chain", itemID(), ModBlocks.CHAIN));
	}
}
