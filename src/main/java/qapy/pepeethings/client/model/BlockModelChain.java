package qapy.pepeethings.client.model;

import net.minecraft.client.render.block.model.BlockModelRope;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLanternFirefly;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;
import qapy.pepeethings.block.BlockLogicChain;

public class BlockModelChain<T extends BlockLogicChain> extends BlockModelRope<T> {
	public static IconCoordinate ICON_CHAIN_VERTICAL;
	public static IconCoordinate ICON_CHAIN_HORIZONTAL;
	public BlockModelChain(Block<?> block) {
		super((Block<T>) block);
	}
	@Override
	public boolean render(Tessellator tessellator, int x, int y, int z) {
		WorldSource world = renderBlocks.blockAccess;
		Block<?> below;
		boolean hasFloor = (below = world.getBlock(x, y - 1, z)) != null && below.canPlaceOnSurface();
		boolean hasBlockNegX = this.canConnect(world, x, y, z, Side.WEST);
		boolean hasBlockPosX = this.canConnect(world, x, y, z, Side.EAST);
		boolean hasBlockNegY = this.canConnect(world, x, y, z, Side.BOTTOM) || hasFloor;
		boolean hasBlockPosY = this.canConnect(world, x, y, z, Side.TOP);
		boolean hasBlockNegZ = this.canConnect(world, x, y, z, Side.NORTH);
		boolean hasBlockPosZ = this.canConnect(world, x, y, z, Side.SOUTH);
		boolean drawKnot = (!hasBlockNegX || !hasBlockPosX || hasBlockNegY || hasBlockPosY || hasBlockNegZ || hasBlockPosZ) && (hasBlockNegX || hasBlockPosX || !hasBlockNegY || !hasBlockPosY || hasBlockNegZ || hasBlockPosZ) && (hasBlockNegX || hasBlockPosX || hasBlockNegY || hasBlockPosY || !hasBlockNegZ || !hasBlockPosZ);
		AABB bounds = AABB.getTemporaryBB((double)0.0F, (double)0.0F, (double)0.0F, (double)1.0F, (double)1.0F, (double)1.0F);
		if (drawKnot) {
			bounds.set((double)0.4375F, (double)0.375F, (double)0.4375F, (double)0.5625F, (double)0.5625F, (double)0.5625F);
			this.setAllTextures(0, ICON_CHAIN_VERTICAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		if (hasBlockPosY) {
			bounds.set((double)0.4375F, (double)0.5F, (double)0.4375F, (double)0.5625F, (double)1.0F, (double)0.5625F);
			this.setAllTextures(0, ICON_CHAIN_VERTICAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		if (hasBlockNegY) {
			bounds.set((double)0.4375F, (double)0.0F, (double)0.4375F, (double)0.5625F, (double)0.5F, (double)0.5625F);
			this.setAllTextures(0, ICON_CHAIN_VERTICAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		if (hasBlockPosX) {
			bounds.set((double)0.5F, (double)0.4375F, (double)0.4375F, (double)1.0F, (double)0.5625F, (double)0.5625F);
			this.setAllTextures(0, ICON_CHAIN_HORIZONTAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		if (hasBlockNegX) {
			bounds.set((double)0.0F, (double)0.4375F, (double)0.4375F, (double)0.5F, (double)0.5625F, (double)0.5625F);
			this.setAllTextures(0, ICON_CHAIN_HORIZONTAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		if (hasBlockPosZ) {
			bounds.set((double)0.4375F, (double)0.4375F, (double)0.5F, (double)0.5625F, (double)0.5625F, (double)1.0F);
			this.setAllTextures(0, ICON_CHAIN_HORIZONTAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		if (hasBlockNegZ) {
			bounds.set((double)0.4375F, (double)0.4375F, (double)0.0F, (double)0.5625F, (double)0.5625F, (double)0.5F);
			this.setAllTextures(0, ICON_CHAIN_HORIZONTAL);
			this.renderStandardBlock(tessellator, bounds, x, y, z);
		}

		return true;
	}
	private boolean canConnect(WorldSource worldSource, int x, int y, int z, Side side) {
		int blockX = x + side.getOffsetX();
		int blockY = y + side.getOffsetY();
		int blockZ = z + side.getOffsetZ();
		Block<?> _block = worldSource.getBlock(blockX, blockY, blockZ);
		if (side == Side.BOTTOM) {
			if (Block.hasLogicClass(_block, BlockLogicLanternFirefly.class) && (worldSource.getBlockMetadata(blockX, blockY, blockZ) & 1) != 0) {
				return true;
			}
		} else if (side == Side.TOP && (worldSource.isBlockOpaqueCube(blockX, blockY, blockZ) || BlockTags.CAN_HANG_OFF.appliesTo(_block))) {
			return true;
		}

		if ((worldSource.getBlockMetadata(x, y, z) & 128) != 0 && worldSource.isBlockOpaqueCube(blockX, blockY, blockZ)) {
			return true;
		} else {
			return _block == this.block;
		}
	}
	static {
		ICON_CHAIN_VERTICAL = TextureRegistry.getTexture("pepeethings:block/chain/chain_vertical");
		ICON_CHAIN_HORIZONTAL = TextureRegistry.getTexture("pepeethings:block/chain/chain_horizontal");
	}
}
