package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFarmland;
import net.minecraft.core.block.BlockLogicFlower;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BlockLogicCrops extends BlockLogicFlower implements IBonemealable {
	private final Item SEED_ITEM;
	private final Item CROP_ITEM;
	private final int MAX_YIELD;

	public BlockLogicCrops(Block<?> block, Item seedItem, Item cropItem, int yield) {
		super(block);
		block.setTicking(true);
		float f = 0.5F;
		this.setBlockBounds((double)(0.5F - f), (double)0.0F, (double)(0.5F - f), (double)(0.5F + f), (double)0.25F, (double)(0.5F + f));
		this.SEED_ITEM = seedItem;
		this.CROP_ITEM = cropItem;
		this.MAX_YIELD = yield;
	}

	public boolean mayPlaceOn(@NotNull Block<?> block) {
		return block == Blocks.FARMLAND_DIRT;
	}

	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		super.updateTick(world, tilePos, rand, isRandomTick);
		if (world.getBlockLightValue(tilePos.up(new TilePos())) >= 9) {
			int data = world.getBlockData(tilePos);
			if (data < 7) {
				float growthRate = this.getGrowthRate(world, tilePos);
				if (rand.nextInt((int)(100.0F / growthRate)) == 0) {
					world.setBlockDataNotify(tilePos, data + 1);
				}
			}
		}

	}

	private float getGrowthRate(@NotNull World world, @NotNull TilePosc tilePos) {
		float growthRate = 1.0F;
		TilePos queryPos = new TilePos();
		Block<?> bNegZ = world.getBlockType(tilePos.north(queryPos));
		Block<?> bPosZ = world.getBlockType(tilePos.south(queryPos));
		Block<?> bNegX = world.getBlockType(tilePos.west(queryPos));
		Block<?> bPosX = world.getBlockType(tilePos.east(queryPos));
		Block<?> bNegXNegZ = world.getBlockType(tilePos.west(queryPos).north(queryPos));
		Block<?> bPosXNegZ = world.getBlockType(tilePos.east(queryPos).north(queryPos));
		Block<?> bPosXPosZ = world.getBlockType(tilePos.east(queryPos).south(queryPos));
		Block<?> bNegXPosZ = world.getBlockType(tilePos.west(queryPos).south(queryPos));
		boolean xNeighbor = bNegX == this.block || bPosX == this.block;
		boolean zNeighbor = bNegZ == this.block || bPosZ == this.block;
		boolean diagNeighbor = bNegXNegZ == this.block || bPosXNegZ == this.block || bPosXPosZ == this.block || bNegXPosZ == this.block;
		TilePos localPos = new TilePos(tilePos);

		for(localPos.x = tilePos.x() - 1; localPos.x <= tilePos.x() + 1; ++localPos.x) {
			for(localPos.z = tilePos.z() - 1; localPos.z <= tilePos.z() + 1; ++localPos.z) {
				Block<?> block = world.getBlockType(tilePos.down(queryPos));
				float growthRateMod = 0.0F;
				if (block == Blocks.FARMLAND_DIRT) {
					growthRateMod = 1.0F;
					if (world.getBlockData(tilePos.down(queryPos)) > 0) {
						growthRateMod = 3.0F;
					}
				}

				if (!tilePos.equals(localPos)) {
					growthRateMod /= 4.0F;
				}

				growthRate += growthRateMod;
			}
		}

		if (diagNeighbor || xNeighbor && zNeighbor) {
			growthRate /= 2.0F;
		}

		boolean isFertilized = BlockLogicFarmland.isFertilized(world.getBlockData(tilePos.down(queryPos)));
		if (!isFertilized) {
			if (world.getSeasonManager().getCurrentSeason() != null) {
				growthRate *= world.getSeasonManager().getCurrentSeason().cropGrowthFactor;
			}
		} else {
			growthRate *= 1.5F;
		}

		return growthRate;
	}

	public void onDestroyedByPlayer(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, int data, @NotNull Player player, @Nullable Item item) {
		TilePos queryPos = new TilePos();
		boolean isFertilized = BlockLogicFarmland.isFertilized(world.getBlockData(tilePos.down(queryPos)));
		if (isFertilized && !world.isClientSide) {
			boolean shouldDefertilize = world.rand.nextInt(3) == 2;
			if (shouldDefertilize) {
				world.setBlockData(tilePos.down(queryPos), BlockLogicFarmland.setFertilized(world.getBlockData(tilePos.down(queryPos)), false));
			}
		}

	}

	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return meta != 7 ? new ItemStack[]{new ItemStack(SEED_ITEM)} : new ItemStack[]{new ItemStack(SEED_ITEM, world.rand.nextInt(3) + 1), new ItemStack(CROP_ITEM, world.rand.nextInt(MAX_YIELD) + 1)};
	}

	public boolean onBonemealUsed(@NotNull ItemStack itemStack, @Nullable Player player, @NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		if (world.getBlockData(tilePos) >= 7) {
			return false;
		} else {
			if (!world.isClientSide) {
				world.setBlockDataNotify(tilePos, 7);
				if (player == null || player.getGamemode().hasBlockConsumption()) {
					--itemStack.stackSize;
				}
			}

			return true;
		}
	}
}
