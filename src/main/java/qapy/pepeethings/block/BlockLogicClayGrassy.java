package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import qapy.pepeethings.ModBlocks;

import java.util.Random;

public class BlockLogicClayGrassy extends BlockLogicClayBase{
	public BlockLogicClayGrassy(@NotNull Block<?> block, Item dropItem) {
		super(block, dropItem);
		block.setTicking(true);
	}

	@Override
	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		if (!world.isClientSide) {
			TilePos queryPos = new TilePos();
			if (world.getBlockLightValue(tilePos.up(queryPos)) < 4 && world.getBlockType(tilePos.up(queryPos)).lightBlock() > 2) {
				world.setBlockTypeNotify(tilePos, ModBlocks.BLOCK_CLAY_BLACK);
			} else if (world.getBlockLightValue(tilePos.up(queryPos)) >= 9) {
				for (int i = 0; i < 4; ++i) {
					int checkX = tilePos.x() + rand.nextInt(3) - 1;
					int checkY = tilePos.y() + rand.nextInt(5) - 3;
					int checkZ = tilePos.z() + rand.nextInt(3) - 1;
					if (world.getBlockType(queryPos.set(checkX, checkY, checkZ)) == ModBlocks.BLOCK_CLAY_BLACK && world.getBlockLightValue(queryPos.set(checkX, checkY + 1, checkZ)) >= 4 && world.getBlockType(queryPos.set(checkX, checkY + 1, checkZ)).lightBlock() <= 2) {
						world.setBlockTypeNotify(queryPos.set(checkX, checkY, checkZ), this.block);
					}
				}
				if (world.getGameRuleValue(GameRules.DO_SEASONAL_GROWTH) && world.getBlockType(tilePos.up(queryPos)) == Blocks.AIR && world.getSeasonManager().getCurrentSeason() != null && world.getSeasonManager().getCurrentSeason().growFlowers && rand.nextInt(512) == 0) {
					Block<?> blockToSpawn;
					if (rand.nextInt(400) < 26) {
						blockToSpawn = ModBlocks.FLOWER_HIBISCUS;
					} else {
						blockToSpawn = Blocks.TALLGRASS;
					}
					if (blockToSpawn != null) {
						world.setBlockTypeNotify(tilePos.up(queryPos), blockToSpawn);
					}
				}
			}
		}
	}
}
