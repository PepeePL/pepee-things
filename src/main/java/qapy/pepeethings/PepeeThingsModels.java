package qapy.pepeethings;

import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorCustom;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelGlass;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.client.render.colorizer.Colorizers;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import qapy.pepeethings.client.model.*;

import static net.minecraft.client.render.block.model.BlockModelDispatcher.loadDataModel;
import static net.minecraft.client.render.item.model.ItemModelDispatcher.*;


public class PepeeThingsModels {
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(new BlockModelGenericGlassColored<>(ModBlocks.GLASS_COLORED, loadDataModel("pepeethings:block/glass_colored/white").asModel()));
		dispatcher.addDispatch(new BlockModelGenericCrops<>(ModBlocks.CROPS_CARROT, "crops_carrot"));
		dispatcher.addDispatch(new BlockModelGenericCrops<>(ModBlocks.CROPS_POTATO, "crops_potato"));
		dispatcher.addDispatch(new BlockModelGenericCrops<>(ModBlocks.CROPS_TOMATO, "crops_tomato"));
		dispatcher.addDispatch(new BlockModelGenericChain<>(ModBlocks.CHAIN));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BLOCK_CLAY_WHITE).setAllTextures("pepeethings:block/block_clay_white"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BLOCK_CLAY_BLACK).setAllTextures("pepeethings:block/block_clay_black"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BLOCK_CLAY_BLUE).setAllTextures("pepeethings:block/block_clay_blue"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BLOCK_CLAY_RED).setAllTextures("pepeethings:block/block_clay_red"));
		dispatcher.addDispatch(new BlockModelGeneric<>(ModBlocks.BLOCK_CLAY_BLACK_GRASSY, loadDataModel("pepeethings:block/clay_black_grassy").asModel()));
		dispatcher.addDispatch(new BlockModelGeneric<>(ModBlocks.FLOWER_HIBISCUS, loadDataModel("pepeethings:block/flower_hibiscus").asModel()).render3D(false));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_BLACK).setAllTextures("pepeethings:block/brick_clay_black"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_BLUE).setAllTextures("pepeethings:block/brick_clay_blue"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_RED).setAllTextures("pepeethings:block/brick_clay_red"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_WHITE).setAllTextures("pepeethings:block/brick_clay_white"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_MOSSY).setAllTextures("pepeethings:block/brick_clay_mossy"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_BLACK_MOSSY).setAllTextures("pepeethings:block/brick_clay_black_mossy"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_BLUE_MOSSY).setAllTextures("pepeethings:block/brick_clay_blue_mossy"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_RED_MOSSY).setAllTextures("pepeethings:block/brick_clay_red_mossy"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BRICK_CLAY_WHITE_MOSSY).setAllTextures("pepeethings:block/brick_clay_white_mossy"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.GRAVEL_GRANITE).setAllTextures("pepeethings:block/gravel_granite"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.GRAVEL_PERMAFROST).setAllTextures("pepeethings:block/gravel_permafrost"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.GRAVEL_LIMESTONE).setAllTextures("pepeethings:block/gravel_limestone"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.GRAVEL_BASALT).setAllTextures("pepeethings:block/gravel_basalt"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.SAND_GRANITE).setAllTextures("pepeethings:block/sand_granite"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.SAND_PERMAFROST).setAllTextures("pepeethings:block/sand_permafrost"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.SAND_ROCKY).setAllTextures("pepeethings:block/sand_rocky"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.SAND_BASALT).setAllTextures("pepeethings:block/sand_basalt"));
		dispatcher.addDispatch(new BlockModelGenericConcretePowder<>(ModBlocks.CONCRETE_POWDER, loadDataModel("pepeethings:block/concrete_powder/white").asModel()));
		dispatcher.addDispatch(new BlockModelGenericConcrete<>(ModBlocks.CONCRETE, loadDataModel("pepeethings:block/concrete/white").asModel()));
		dispatcher.addDispatch(new BlockModelGenericSlabConcretePainted<>(ModBlocks.SLAB_CONCRETE));
		dispatcher.addDispatch(new BlockModelGenericStairsConcretePainted<>(ModBlocks.STAIRS_CONCRETE));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.BLUESCREEN).setAllTextures("pepeethings:block/screen_blue"));
		dispatcher.addDispatch(new BlockModelStandard<>(ModBlocks.GREENSCREEN).setAllTextures("pepeethings:block/screen_green"));
		dispatcher.addDispatch(new BlockModelGlass<>(ModBlocks.GLASS_CLEAR, "pepeethings:block/glass_clear/").setAllTextures("pepeethings:block/glass_clear/none"));
		dispatcher.addDispatch(new BlockModelGlass<>(ModBlocks.GLASS_BUBBLE, "pepeethings:block/glass_bubble/").setAllTextures("pepeethings:block/glass_bubble/none"));
		dispatcher.addDispatch(new BlockModelGlass<>(ModBlocks.GLASS_PATTERNED, "pepeethings:block/glass_patterned/").setAllTextures("pepeethings:block/glass_patterned/none"));
		dispatcher.addDispatch(new BlockModelGlass<>(ModBlocks.GLASS_FRAMED, "pepeethings:block/glass_framed/").setAllTextures("pepeethings:block/glass_framed/none"));

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
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CHAIN));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.BRICK_CLAY_BLACK));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.BRICK_CLAY_BLUE));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.BRICK_CLAY_RED));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.BRICK_CLAY_WHITE));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CLAY_BLACK));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CLAY_BLUE));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CLAY_RED));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.CLAY_WHITE));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SPADE_STONE).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SPADE_IRON).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SPADE_GOLD).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SPADE_DIAMOND).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.TOOL_SPADE_STEEL).setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND).setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND).setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND).setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND));
		dispatcher.addDispatch(new ItemModelStandard(ModItems.MORTAR));
//		ModelHelper.setItemModel(ModItems.CRATE, () -> new ItemModelStandard(ModItems.CRATE));
	}

	public void initEntityModels(EntityRendererDispatcher entityRendererDispatcher) {

	}

	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	public void initBlockColors(BlockColorDispatcher dispatcher) {
		dispatcher.addDispatch(ModBlocks.BLOCK_CLAY_BLACK_GRASSY, new BlockColorCustom(Colorizers.grass));

	}
}
