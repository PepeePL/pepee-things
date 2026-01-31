package qapy.pepeethings;


import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.block.ItemBlockPainted;
import net.minecraft.core.sound.BlockSounds;
import qapy.pepeethings.block.BlockLogicChain;
import qapy.pepeethings.block.BlockLogicGlassColored;
import turniplabs.halplibe.helper.BlockBuilder;

import static qapy.pepeethings.ModConfig.blockID;
import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModBlocks {
	public static Block<?> GLASS_COLORED;
	public static Block<?> CHAIN;

	public void initBlocks(){
		GLASS_COLORED = new BlockBuilder(MOD_ID)
			.build("glass.colored", "glass_colored", blockID(), (b -> new BlockLogicGlassColored(b)))
			.withHardness(0.3F)
			.setBlockItem((b) -> new ItemBlockPainted<>(b, false))
			.withSound(BlockSounds.GLASS)
			.withTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.EXTENDS_MOTION_SENSOR_RANGE);
		CHAIN = new BlockBuilder(MOD_ID)
			.build("chain", "chain", blockID(), (b -> new BlockLogicChain(b)))
			.withHardness(0.8F)
			.withSound(BlockSounds.METAL)
			.withDisabledNeighborNotifyOnMetadataChange().
			setStatParent(() -> Items.ROPE)
			.withTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.PREVENT_MOB_SPAWNS, BlockTags.CAN_HANG_OFF, BlockTags.MINEABLE_BY_PICKAXE);
	}
}
