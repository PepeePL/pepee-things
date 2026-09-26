package qapy.pepeethings;

import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import qapy.pepeethings.client.model.*;

import static net.minecraft.client.render.block.model.BlockModelDispatcher.loadDataModel;
import static net.minecraft.client.render.item.model.ItemModelDispatcher.*;


public class PepeeThingsModels {
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(new BlockModelGenericGlassColored<>(ModBlocks.GLASS_COLORED, loadDataModel("pepeethings:block/glass/white").asModel()));
		dispatcher.addDispatch(new BlockModelGenericCrops<>(ModBlocks.CROPS_CARROT, "crops_carrot"));
		dispatcher.addDispatch(new BlockModelGenericCrops<>(ModBlocks.CROPS_POTATO, "crops_potato"));
		dispatcher.addDispatch(new BlockModelGenericCrops<>(ModBlocks.CROPS_TOMATO, "crops_tomato"));
		dispatcher.addDispatch(new BlockModelGenericChain<>(ModBlocks.CHAIN));

//		ModelHelper.setBlockModel(ModBlocks.CRATE, () -> new BlockModelCrate<>(ModBlocks.CRATE).setAllTextures("pepeethings:block/crate/side"));
	}

	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(new ItemModelNet(ModItems.NET).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_HAMMER_STONE).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_HAMMER_IRON).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_HAMMER_GOLD).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_HAMMER_DIAMOND).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_HAMMER_STEEL).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CHISEL).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CHISEL_STEEL).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.MOSS));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.SEEDS_CARROT));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CARROT));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.SEEDS_POTATO));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.POTATO));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.POTATO_BAKED));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.SEEDS_TOMATO));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOMATO));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.SANDWICH_MEAT));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.SANDWICH_TOMATO));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.STEW_MEAT));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.SOUP_TOMATO));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CARROT_IRON));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SICKLE_WOOD).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SICKLE_STONE).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SICKLE_IRON).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SICKLE_GOLD).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SICKLE_DIAMOND).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SICKLE_STEEL).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
//		ModelHelper.setItemModel(ModItems.CHAIN, () -> new ItemModelStandard(ModItems.CHAIN));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CHAIN));
//		ModelHelper.setItemModel(ModItems.CRATE, () -> new ItemModelStandard(ModItems.CRATE));
	}

	public void initEntityModels(EntityRendererDispatcher entityRendererDispatcher) {

	}

	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
