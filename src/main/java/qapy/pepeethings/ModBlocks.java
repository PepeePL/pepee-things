package qapy.pepeethings;


import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.sound.BlockSounds;
import qapy.pepeethings.block.BlockLogicChain;
import qapy.pepeethings.block.BlockLogicCrate;
import qapy.pepeethings.block.BlockLogicCrops;
import qapy.pepeethings.block.BlockLogicGlassColored;
import turniplabs.halplibe.helper.BlockBuilder;

import static qapy.pepeethings.ModConfig.blockID;
import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModBlocks {
	public static Block<?> GLASS_COLORED;
	public static Block<?> CHAIN;
	public static Block<?> CROPS_CARROT;
	public static Block<?> CROPS_POTATO;
	public static Block<?> CROPS_TOMATO;
	public static Block<?> CRATE;

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
	}
}
