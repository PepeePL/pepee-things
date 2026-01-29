package qapy.pepeethings;


import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.sound.BlockSounds;
import qapy.pepeethings.block.BlockLogicGlassColored;
import turniplabs.halplibe.helper.BlockBuilder;

import static qapy.pepeethings.ModConfig.blockID;
import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModBlocks {
	public static Block<?> GLASS_COLORED;

	public void initBlocks(){
		GLASS_COLORED = new BlockBuilder(MOD_ID)
			.build("glass.colored", "glass_colored", blockID(), (b -> new BlockLogicGlassColored(b)))
			.withHardness(0.3F)
			.setBlockItem((b) -> new ItemBlockPainted<>(b, false))
			.withSound(BlockSounds.GLASS)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.EXTENDS_MOTION_SENSOR_RANGE);
	}
}
