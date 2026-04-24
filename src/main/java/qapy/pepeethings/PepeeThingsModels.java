package qapy.pepeethings;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import qapy.pepeethings.client.model.*;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

public class PepeeThingsModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		ModelHelper.setBlockModel(ModBlocks.GLASS_COLORED, () -> new BlockModelGlassColored<>(ModBlocks.GLASS_COLORED, false).onRenderLayer(1));
		ModelHelper.setBlockModel(ModBlocks.CHAIN, () -> new BlockModelChain<>(ModBlocks.CHAIN));
		ModelHelper.setBlockModel(ModBlocks.CROPS_CARROT, () -> new BlockModelCrops<>(ModBlocks.CROPS_CARROT, "crops_carrot"));
		ModelHelper.setBlockModel(ModBlocks.CROPS_POTATO, () -> new BlockModelCrops<>(ModBlocks.CROPS_POTATO, "crops_potato"));
		ModelHelper.setBlockModel(ModBlocks.CROPS_TOMATO, () -> new BlockModelCrops<>(ModBlocks.CROPS_TOMATO, "crops_tomato"));
		ModelHelper.setBlockModel(ModBlocks.CRATE, () -> new BlockModelCrate<>(ModBlocks.CRATE).setAllTextures(0, "pepeethings:block/crate/side"));
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		ModelHelper.setItemModel(ModItems.CHISEL, () -> new ItemModelStandard(ModItems.CHISEL, null).setIcon("pepeethings:item/chisel").setFull3D());
		ModelHelper.setItemModel(ModItems.CHISEL_STEEL, () -> new ItemModelStandard(ModItems.CHISEL_STEEL, null).setIcon("pepeethings:item/chisel_steel").setFull3D());
		ModelHelper.setItemModel(ModItems.MOSS, () -> new ItemModelStandard(ModItems.MOSS, null).setIcon("pepeethings:item/moss"));
		ModelHelper.setItemModel(ModItems.TOOL_HAMMER_STONE, () -> new ItemModelStandard(ModItems.TOOL_HAMMER_STONE, null).setIcon("pepeethings:item/tool_hammer_stone").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_HAMMER_IRON, () -> new ItemModelStandard(ModItems.TOOL_HAMMER_IRON, null).setIcon("pepeethings:item/tool_hammer_iron").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_HAMMER_GOLD, () -> new ItemModelStandard(ModItems.TOOL_HAMMER_GOLD, null).setIcon("pepeethings:item/tool_hammer_gold").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_HAMMER_DIAMOND, () -> new ItemModelStandard(ModItems.TOOL_HAMMER_DIAMOND, null).setIcon("pepeethings:item/tool_hammer_diamond").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_HAMMER_STEEL, () -> new ItemModelStandard(ModItems.TOOL_HAMMER_STEEL, null).setIcon("pepeethings:item/tool_hammer_steel").setFull3D());
		ModelHelper.setItemModel(ModItems.NET, () -> new ItemModelNet(ModItems.NET));
		ModelHelper.setItemModel(ModItems.CHAIN, () -> new ItemModelStandard(ModItems.CHAIN, null).setIcon("pepeethings:item/chain"));
		ModelHelper.setItemModel(ModItems.TOOL_SICKLE_WOOD, () -> new ItemModelStandard(ModItems.TOOL_SICKLE_WOOD, null).setIcon("pepeethings:item/tool_sickle_wood").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_SICKLE_STONE, () -> new ItemModelStandard(ModItems.TOOL_SICKLE_STONE, null).setIcon("pepeethings:item/tool_sickle_stone").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_SICKLE_IRON, () -> new ItemModelStandard(ModItems.TOOL_SICKLE_IRON, null).setIcon("pepeethings:item/tool_sickle_iron").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_SICKLE_GOLD, () -> new ItemModelStandard(ModItems.TOOL_SICKLE_GOLD, null).setIcon("pepeethings:item/tool_sickle_gold").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_SICKLE_DIAMOND, () -> new ItemModelStandard(ModItems.TOOL_SICKLE_DIAMOND, null).setIcon("pepeethings:item/tool_sickle_diamond").setFull3D());
		ModelHelper.setItemModel(ModItems.TOOL_SICKLE_STEEL, () -> new ItemModelStandard(ModItems.TOOL_SICKLE_STEEL, null).setIcon("pepeethings:item/tool_sickle_steel").setFull3D());
		ModelHelper.setItemModel(ModItems.SEEDS_CARROT, () -> new ItemModelStandard(ModItems.SEEDS_CARROT, null).setIcon("pepeethings:item/seeds_carrot"));
		ModelHelper.setItemModel(ModItems.CARROT, () -> new ItemModelStandard(ModItems.CARROT, null).setIcon("pepeethings:item/carrot"));
		ModelHelper.setItemModel(ModItems.SEEDS_POTATO, () -> new ItemModelStandard(ModItems.SEEDS_POTATO, null).setIcon("pepeethings:item/seeds_potato"));
		ModelHelper.setItemModel(ModItems.POTATO, () -> new ItemModelStandard(ModItems.POTATO, null).setIcon("pepeethings:item/potato"));
		ModelHelper.setItemModel(ModItems.POTATO_BAKED, () -> new ItemModelStandard(ModItems.POTATO_BAKED, null).setIcon("pepeethings:item/potato_baked"));
		ModelHelper.setItemModel(ModItems.SEEDS_TOMATO, () -> new ItemModelStandard(ModItems.SEEDS_TOMATO, null).setIcon("pepeethings:item/seeds_tomato"));
		ModelHelper.setItemModel(ModItems.TOMATO, () -> new ItemModelStandard(ModItems.TOMATO, null).setIcon("pepeethings:item/tomato"));
		ModelHelper.setItemModel(ModItems.SANDWICH_MEAT, () -> new ItemModelStandard(ModItems.SANDWICH_MEAT, null).setIcon("pepeethings:item/sandwich_meat"));
		ModelHelper.setItemModel(ModItems.SANDWICH_TOMATO, () -> new ItemModelStandard(ModItems.SANDWICH_TOMATO, null).setIcon("pepeethings:item/sandwich_tomato"));
		ModelHelper.setItemModel(ModItems.STEW_MEAT, () -> new ItemModelStandard(ModItems.STEW_MEAT, null).setIcon("pepeethings:item/stew_meat"));
		ModelHelper.setItemModel(ModItems.SOUP_TOMATO, () -> new ItemModelStandard(ModItems.SOUP_TOMATO, null).setIcon("pepeethings:item/soup_tomato"));
		ModelHelper.setItemModel(ModItems.CARROT_IRON, () -> new ItemModelStandard(ModItems.CARROT_IRON, null).setIcon("pepeethings:item/carrot_iron"));
		ModelHelper.setItemModel(ModItems.CRATE, () -> new ItemModelStandard(ModItems.CRATE, null).setIcon("pepeethings:item/crate"));
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
