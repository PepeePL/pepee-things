package qapy.pepeethings;


import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.item.block.ItemBlockSlabPainted;
import net.minecraft.core.item.block.ItemBlockStairsPainted;
import net.minecraft.core.sound.BlockSounds;
import qapy.pepeethings.block.*;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import static qapy.pepeethings.ModConfig.blockID;
import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModBlocks {
	public static Block<?> GLASS_COLORED;
	public static Block<?> CHAIN;
	public static Block<?> CROPS_CARROT;
	public static Block<?> CROPS_POTATO;
	public static Block<?> CROPS_TOMATO;
	public static Block<?> CRATE;
	public static Block<?> BLOCK_CLAY_BLACK;
	public static Block<?> BLOCK_CLAY_BLACK_GRASSY;
	public static Block<?> BLOCK_CLAY_BLUE;
	public static Block<?> BLOCK_CLAY_RED;
	public static Block<?> BLOCK_CLAY_WHITE;
	public static Block<?> FLOWER_HIBISCUS;
	public static Block<?> BRICK_CLAY_BLACK;
	public static Block<?> BRICK_CLAY_BLUE;
	public static Block<?> BRICK_CLAY_RED;
	public static Block<?> BRICK_CLAY_WHITE;
	public static Block<?> BRICK_CLAY_MOSSY;
	public static Block<?> BRICK_CLAY_BLACK_MOSSY;
	public static Block<?> BRICK_CLAY_BLUE_MOSSY;
	public static Block<?> BRICK_CLAY_RED_MOSSY;
	public static Block<?> BRICK_CLAY_WHITE_MOSSY;
	public static Block<?> GRAVEL_GRANITE;
	public static Block<?> GRAVEL_PERMAFROST;
	public static Block<?> GRAVEL_LIMESTONE;
	public static Block<?> GRAVEL_BASALT;
	public static Block<?> SAND_GRANITE;
	public static Block<?> SAND_PERMAFROST;
	public static Block<?> SAND_ROCKY;
	public static Block<?> SAND_BASALT;
	public static Block<?> CONCRETE_POWDER;
	public static Block<?> CONCRETE;
	public static Block<?> SLAB_CONCRETE;
	public static Block<?> STAIRS_CONCRETE;

	public void initBlocks(){
		GLASS_COLORED = new BlockBuilder(MOD_ID)
			.build("glass.colored", "glass_colored", blockID(), (b -> new BlockLogicGlassColored(b)))
			.withHardness(0.3F)
			.setBlockItem((b) -> new ItemBlockPainted<>(b, false))
			.withSound(BlockSounds.GLASS)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.EXTENDS_MOTION_SENSOR_RANGE);
		CHAIN = new BlockBuilder(MOD_ID)
			.build("chain", "chain", blockID(), (b -> new BlockLogicChain(b)))
			.withHardness(1.0F)
			.withSound(BlockSounds.METAL)
			.setStatParent(() -> Items.ROPE)
			.withTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.PREVENT_MOB_SPAWNS, BlockTags.CAN_HANG_OFF, BlockTags.MINEABLE_BY_PICKAXE);
		CROPS_CARROT = new BlockBuilder(MOD_ID)
			.build("crop.carrot", "crop_carrot", blockID(), (b -> new BlockLogicCrops(b, ModItems.SEEDS_CARROT, ModItems.CARROT, 2)))
			.withHardness(0.0F)
			.withSound(BlockSounds.GRASS)
			.withTags(BlockTags.NOT_IN_CREATIVE_MENU);
		CROPS_POTATO = new BlockBuilder(MOD_ID)
			.build("crop.potato", "crop_potato", blockID(), (b -> new BlockLogicCrops(b, ModItems.SEEDS_POTATO, ModItems.POTATO, 2)))
			.withHardness(0.0F)
			.withSound(BlockSounds.GRASS)
			.withTags(BlockTags.NOT_IN_CREATIVE_MENU);
		CROPS_TOMATO = new BlockBuilder(MOD_ID)
			.build("crop.tomato", "crop_tomato", blockID(), (b -> new BlockLogicCrops(b, ModItems.SEEDS_TOMATO, ModItems.TOMATO, 2)))
			.withHardness(0.0F)
			.withSound(BlockSounds.GRASS)
			.withTags(BlockTags.NOT_IN_CREATIVE_MENU);
		CRATE = new BlockBuilder(MOD_ID)
			.build("crate", "crate", blockID(), (b -> new BlockLogicCrate(b, Materials.WOOD, ModItems.CRATE)))
			.withHardness(1.5F)
			.setStatParent(() -> ModItems.CRATE)
			.withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.NOT_IN_CREATIVE_MENU)
			.withSound(BlockSounds.WOOD);
		BLOCK_CLAY_BLACK = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("block.clay.black", "block_clay_black", blockID(), (b -> new BlockLogicClayBase(b, ModItems.CLAY_BLACK)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		BLOCK_CLAY_BLACK_GRASSY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("block.clay.black.grassy", "block_clay_black_grassy", blockID(), (b -> new BlockLogicClayGrassy(b, ModItems.CLAY_BLACK)))
			.withHardness(0.65F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.GROWS_FLOWERS);
		BLOCK_CLAY_BLUE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("block.clay.blue", "block_clay_blue", blockID(), (b -> new BlockLogicClayBase(b, ModItems.CLAY_BLUE)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		BLOCK_CLAY_RED = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("block.clay.red", "block_clay_red", blockID(), (b -> new BlockLogicClayBase(b, ModItems.CLAY_RED)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		BLOCK_CLAY_WHITE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("block.clay.white", "block_clay_white", blockID(), (b -> new BlockLogicClayBase(b, ModItems.CLAY_WHITE)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		FLOWER_HIBISCUS = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORGANIC))
			.build("flower.hibiscus", "flower_hibiscus", blockID(), (b -> new BlockLogicFlower(b)))
			.withHardness(0.0F)
			.withSound(BlockSounds.GRASS)
			.withTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.PLANTABLE_IN_JAR, BlockTags.SHEEPS_FAVOURITE_BLOCK, BlockTags.SHEARS_DO_SILK_TOUCH);
		BRICK_CLAY_BLACK = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.black", "brick_clay_black", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_BLUE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.blue", "brick_clay_blue", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_RED = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.red", "brick_clay_red", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_WHITE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.white", "brick_clay_white", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_MOSSY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.mossy", "brick_clay_mossy", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_BLACK_MOSSY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.black.mossy", "brick_clay_black_mossy", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_BLUE_MOSSY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.blue.mossy", "brick_clay_blue_mossy", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_RED_MOSSY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.red.mossy", "brick_clay_red_mossy", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		BRICK_CLAY_WHITE_MOSSY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("brick.clay.white.mossy", "brick_clay_white_mossy", blockID(), (b -> new BlockLogic(b, Materials.STONE)))
			.withHardness(2F)
			.withBlastResistance(10F)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		GRAVEL_GRANITE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("gravel.granite", "gravel_granite", blockID(), (b -> new BlockLogicGravelBase(b, ModBlocks.SAND_GRANITE)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		GRAVEL_PERMAFROST = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("gravel.permafrost", "gravel_permafrost", blockID(), (b -> new BlockLogicGravelBase(b, ModBlocks.SAND_PERMAFROST)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		GRAVEL_LIMESTONE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("gravel.limestone", "gravel_limestone", blockID(), (b -> new BlockLogicGravelBase(b, Blocks.SAND)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		GRAVEL_BASALT = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("gravel.basalt", "gravel_basalt", blockID(), (b -> new BlockLogicGravelBase(b, ModBlocks.SAND_BASALT)))
			.withHardness(0.6F)
			.withSound(BlockSounds.GRAVEL)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		SAND_GRANITE = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("sand.granite", "sand_granite", blockID(), (b -> new BlockLogicFallingBlock(b, Materials.SAND)))
			.withHardness(0.5F)
			.withSound(BlockSounds.SAND)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		SAND_PERMAFROST = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("sand.permafrost", "sand_permafrost", blockID(), (b -> new BlockLogicFallingBlock(b, Materials.SAND)))
			.withHardness(0.5F)
			.withSound(BlockSounds.SAND)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		SAND_ROCKY = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("sand.rocky", "sand_rocky", blockID(), (b -> new BlockLogicFallingBlock(b, Materials.SAND)))
			.withHardness(0.5F)
			.withSound(BlockSounds.SAND)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		SAND_BASALT = new BlockBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.NATURAL))
			.build("sand.basalt", "sand_basalt", blockID(), (b -> new BlockLogicFallingBlock(b, Materials.SAND)))
			.withHardness(0.5F)
			.withSound(BlockSounds.SAND)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		CONCRETE_POWDER = new BlockBuilder(MOD_ID)
			.build("concrete.powder", "concrete_powder", blockID(), (b -> new BlockLogicConcretePowder(b, Materials.SAND)))
			.withHardness(0.5F)
			.setBlockItem((b) -> new ItemBlockPainted<>(b, false))
			.withSound(BlockSounds.SAND)
			.withTags(BlockTags.MINEABLE_BY_SHOVEL);
		CONCRETE = new BlockBuilder(MOD_ID)
			.build("concrete", "concrete", blockID(), (b -> new BlockLogicConcrete(b, Materials.STONE)))
			.withHardness(1.8F)
			.setBlockItem((b) -> new ItemBlockPainted<>(b, false))
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		SLAB_CONCRETE = new BlockBuilder(MOD_ID)
			.build("slab.concrete", "slab_concrete", blockID(), (b -> new BlockLogicSlabPainted(b, ModBlocks.CONCRETE)))
			.withHardness(1.8F)
			.withLitInteriorSurface(true)
			.setBlockItem(ItemBlockSlabPainted::new)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
		STAIRS_CONCRETE = new BlockBuilder(MOD_ID)
			.build("stairs.concrete", "stairs_concrete", blockID(), (b -> new BlockLogicStairsPainted(b, ModBlocks.CONCRETE)))
			.withHardness(1.8F)
			.setBlockItem(ItemBlockStairsPainted::new)
			.withSound(BlockSounds.STONE)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);
	}
}
