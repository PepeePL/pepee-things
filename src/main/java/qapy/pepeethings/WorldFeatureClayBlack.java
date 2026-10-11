package qapy.pepeethings;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureClayBlack extends WorldFeature {
	private final int numberOfBlocks;

	public WorldFeatureClayBlack(int numberOfBlocks) {
		this.numberOfBlocks = numberOfBlocks;
	}

	public boolean place(World world, Random random, int x, int y, int z) {
		double radius = this.numberOfBlocks * random.nextDouble() + 0.5D;

		int minX = (int) Math.floor(x - radius);
		int maxX = (int) Math.ceil(x + radius);
		int minY = (int) Math.floor(y - radius);
		int maxY = (int) Math.ceil(y + radius);
		int minZ = (int) Math.floor(z - radius);
		int maxZ = (int) Math.ceil(z + radius);

		double radiusSquared = radius * radius;

		for (int x1 = minX; x1 <= maxX; ++x1) {
			for (int y1 = minY; y1 <= maxY; ++y1) {
				for (int z1 = minZ; z1 <= maxZ; ++z1) {
					double dx = x1 + 0.5D - x;
					double dy = y1 + 0.5D - y;
					double dz = z1 + 0.5D - z;

					if (dx * dx + dy * dy + dz * dz <= radiusSquared){
						Block<?> blockID = world.getBlock(x1, y1, z1);
						if (blockID.equals(Blocks.GRASS)) {
							world.setBlock(x1, y1, z1, ModBlocks.BLOCK_CLAY_BLACK_GRASSY.id());
							if(random.nextInt(10) == 1){
								world.setBlock(x1, y1 + 1, z1, ModBlocks.FLOWER_HIBISCUS.id());
							}
						} else if (blockID.equals(Blocks.DIRT)) {
							world.setBlock(x1, y1, z1, ModBlocks.BLOCK_CLAY_BLACK.id());
						}

					}
				}
			}
		}

		return true;
	}
}
