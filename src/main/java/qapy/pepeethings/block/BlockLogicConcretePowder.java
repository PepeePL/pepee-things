package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFallingBlock;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityFallingBlock;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qapy.pepeethings.ModBlocks;

import java.util.Random;

public class BlockLogicConcretePowder extends BlockLogicFallingBlock implements IPainted {

	public BlockLogicConcretePowder(@NotNull Block<?> block, @NotNull Material material) {
		super(block, material);
	}

	@Override
	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case SILK_TOUCH:
				return new ItemStack[]{new ItemStack(this, 1, meta)};
			default:
				return null;
		}
	}

	@Override
	public void onNeighborChanged(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Block<?> block) {
		world.scheduleBlockUpdate(tilePos, this.block, (long)this.tickDelay());
		solidify(world, tilePos, block);
	}

	@Override
	public void updateTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand, boolean isRandomTick) {
		tryToFall(world, tilePos, world.getBlockData(tilePos));
	}

	@Override
	public void onPlacedByWorld(@NotNull World world, @NotNull TilePosc tilePos) {
		world.scheduleBlockUpdate(tilePos, this.block, this.tickDelay());
		TilePos queryPos = new TilePos(tilePos.x(), tilePos.y() + 1, tilePos.z());
		solidify(world, tilePos, world.getBlockType(queryPos));
		queryPos = new TilePos(tilePos.x(), tilePos.y() - 1, tilePos.z());
		solidify(world, tilePos, world.getBlockType(queryPos));
		queryPos = new TilePos(tilePos.x() + 1, tilePos.y(), tilePos.z());
		solidify(world, tilePos, world.getBlockType(queryPos));
		queryPos = new TilePos(tilePos.x() - 1, tilePos.y(), tilePos.z());
		solidify(world, tilePos, world.getBlockType(queryPos));
		queryPos = new TilePos(tilePos.x(), tilePos.y(), tilePos.z() + 1);
		solidify(world, tilePos, world.getBlockType(queryPos));
		queryPos = new TilePos(tilePos.x(), tilePos.y(), tilePos.z() - 1);
		solidify(world, tilePos, world.getBlockType(queryPos));
	}

	private void tryToFall(@NotNull World world, @NotNull TilePosc tilePos, int meta) {
		TilePos queryPos = new TilePos();
		if (canFallBelow(world, tilePos.down(queryPos)) && tilePos.y() >= 0) {
			byte radius = 32;
			if (!fallInstantly && world.areBlocksLoaded(tilePos.add(-radius, -radius, -radius, new TilePos()), tilePos.add(radius, radius, radius, new TilePos()))) {
				EntityFallingBlock entityFallingBlock = new EntityFallingBlock(world, (double)tilePos.x() + (double)0.5F, (double)tilePos.y() + (double)0.5F, (double)tilePos.z() + (double)0.5F, this.block.id(), meta, (TileEntity)null);
				world.entityJoinedWorld(entityFallingBlock);
			} else {
				world.setBlockTypeNotify(tilePos, Blocks.AIR);
				TilePos check = tilePos.down(new TilePos());

				while(canFallBelow(world, check) && check.y > 0) {
					check.down();
				}

				if (check.y > 0) {
					world.setBlockTypeDataNotify(check, this.block, meta);
				}
			}
		}

	}
	private void solidify(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Block<?> block) {
		if(block.hasTag(BlockTags.IS_WATER)){
			world.setBlockTypeDataNotify(tilePos, ModBlocks.CONCRETE, world.getBlockData(tilePos));
		}
	}

	private static boolean canFallBelow(@NotNull World world, @NotNull TilePos tilePos) {
		Block<?> block = world.getBlockType(tilePos);
		return block == Blocks.AIR || block.hasTag(BlockTags.PLACE_OVERWRITES);
	}

	public int getPlacedData(@Nullable Player player, @NotNull ItemStack itemStack, @NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		return itemStack.getMetadata();
	}

	@Override
	public @NotNull DyeColor fromMetadata(int meta) {
		return DyeColor.colorFromBlockMeta(meta);
	}

	@Override
	public int toMetadata(DyeColor color) {
		return color.blockMeta;
	}

	@Override
	public int stripColorFromMetadata(int meta) {
		return 0;
	}

	@Override
	public void removeDye(@NotNull World world, @NotNull TilePosc tilePosc) {
		world.setBlockDataNotify(tilePosc, 0);
	}

	@Override
	public @NotNull DyeColor getColor(@NotNull World world, @NotNull TilePosc tilePos) {
		return IPainted.super.getColor(world, tilePos);
	}
}
