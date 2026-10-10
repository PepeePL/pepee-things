package qapy.pepeethings;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRope;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ToolMaterial;
import qapy.pepeethings.item.*;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

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
	public static Item TOOL_SICKLE_WOOD;
	public static Item TOOL_SICKLE_STONE;
	public static Item TOOL_SICKLE_IRON;
	public static Item TOOL_SICKLE_GOLD;
	public static Item TOOL_SICKLE_DIAMOND;
	public static Item TOOL_SICKLE_STEEL;
	public static Item SEEDS_CARROT;
	public static Item CARROT;
	public static Item SEEDS_POTATO;
	public static Item POTATO;
	public static Item POTATO_BAKED;
	public static Item TOMATO;
	public static Item SEEDS_TOMATO;
	public static Item SANDWICH_MEAT;
	public static Item SANDWICH_TOMATO;
	public static Item STEW_MEAT;
	public static Item SOUP_TOMATO;
	public static Item CARROT_IRON;
	public static Item CRATE;

	public void initItems(){
		CHISEL = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemChisel("chisel", "pepeethings:item/chisel", itemID(), true));
		CHISEL_STEEL = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemChisel("chisel.steel", "pepeethings:item/chisel_steel", itemID(), false));
		MOSS = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build(new ItemMoss("moss", "pepeethings:item/moss", itemID()));
		TOOL_HAMMER_STONE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHammer("tool.hammer.stone", "pepeethings:item/tool_hammer_stone", itemID(), ItemToolHammer.Tool.PICKAXE, ToolMaterial.stone, BlockTags.MINEABLE_BY_PICKAXE));
		TOOL_HAMMER_IRON = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHammer("tool.hammer.iron", "pepeethings:item/tool_hammer_iron", itemID(), ItemToolHammer.Tool.PICKAXE, ToolMaterial.iron, BlockTags.MINEABLE_BY_PICKAXE));
		TOOL_HAMMER_GOLD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHammer("tool.hammer.gold", "pepeethings:item/tool_hammer_gold", itemID(), ItemToolHammer.Tool.PICKAXE, ToolMaterial.gold, BlockTags.MINEABLE_BY_PICKAXE));
		TOOL_HAMMER_DIAMOND = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHammer("tool.hammer.diamond", "pepeethings:item/tool_hammer_diamond", itemID(), ItemToolHammer.Tool.PICKAXE, ToolMaterial.diamond, BlockTags.MINEABLE_BY_PICKAXE));
		TOOL_HAMMER_STEEL = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHammer("tool.hammer.steel", "pepeethings:item/tool_hammer_steel", itemID(), ItemToolHammer.Tool.PICKAXE, ToolMaterial.steel, BlockTags.MINEABLE_BY_PICKAXE));
		NET = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemNet("net", "pepeethings:item/net", itemID()));
		TOOL_SICKLE_WOOD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemSickle("tool.sickle.wood", "pepeethings:item/tool_sickle_wood", itemID(), 2, ToolMaterial.wood));
		TOOL_SICKLE_STONE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemSickle("tool.sickle.stone", "pepeethings:item/tool_sickle_stone", itemID(), 2, ToolMaterial.stone));
		TOOL_SICKLE_IRON = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemSickle("tool.sickle.iron", "pepeethings:item/tool_sickle_iron", itemID(), 2, ToolMaterial.iron));
		TOOL_SICKLE_GOLD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemSickle("tool.sickle.gold", "pepeethings:item/tool_sickle_gold", itemID(), 2, ToolMaterial.gold));
		TOOL_SICKLE_DIAMOND = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemSickle("tool.sickle.diamond", "pepeethings:item/tool_sickle_diamond", itemID(), 2, ToolMaterial.diamond));
		TOOL_SICKLE_STEEL = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemSickle("tool.sickle.steel", "pepeethings:item/tool_sickle_steel", itemID(), 2, ToolMaterial.steel));
		CHAIN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.PLACEABLES))
			.build(new ItemRope("chain", "pepeethings:item/chain", itemID(), (Block<BlockLogicRope>) ModBlocks.CHAIN));
		SEEDS_CARROT = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORGANIC))
			.build(new ItemSeeds("seeds.carrot", "pepeethings:item/seeds_carrot", itemID(), ModBlocks.CROPS_CARROT));
		CARROT = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood("carrot", "pepeethings:item/carrot", itemID(), 3, 8, false, 8));
		SEEDS_POTATO = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORGANIC))
			.build(new ItemSeeds("seeds.potato", "pepeethings:item/seeds_potato", itemID(), ModBlocks.CROPS_POTATO));
		POTATO = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood("potato", "pepeethings:item/potato", itemID(), 1, 6, false, 8));
		POTATO_BAKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood("potato.baked", "pepeethings:item/potato_baked", itemID(), 5, 10, false, 8));
		SEEDS_TOMATO = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORGANIC))
			.build(new ItemSeeds("seeds.tomato", "pepeethings:item/seeds_tomato", itemID(), ModBlocks.CROPS_TOMATO));
		TOMATO = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood("tomato", "pepeethings:item/tomato", itemID(), 2, 8, false, 8));
		SANDWICH_MEAT = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFoodPortioned("sandwich.meat", "pepeethings:item/sandwich_meat", itemID(), 8, 16, 2));
		SANDWICH_TOMATO = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFoodPortioned("sandwich.tomato", "pepeethings:item/sandwich_tomato", itemID(), 6, 16, 2));
		STEW_MEAT = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemSoup("stew.meat", "pepeethings:item/stew_meat", itemID(), 12, 16));
		SOUP_TOMATO = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemSoup("soup.tomato", "pepeethings:item/soup_tomato", itemID(), 10, 16));
		CARROT_IRON = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood("carrot.iron", "pepeethings:item/carrot_iron", itemID(), 7, 0, false, 2));
		CRATE = new ItemBuilder(MOD_ID)
			.build(new ItemPlaceable("crate", "pepeethings:item/crate", itemID(), ModBlocks.CRATE));
	}
}
