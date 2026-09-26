package qapy.pepeethings.client.model;

import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicJarButterfly;
import net.minecraft.core.block.BlockLogicLanternFirefly;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.useless.dragonfly.models.block.StaticBlockModel;

public class BlockModelGenericChain<T extends BlockLogic> extends BlockModelGeneric<T> {
	public final @NotNull StaticBlockModel line = BlockModelDispatcher.loadDataModel("pepeethings:block/chain/line").asModel();
	public final @NotNull StaticBlockModel knot = BlockModelDispatcher.loadDataModel("pepeethings:block/chain/knot").asModel();

	public BlockModelGenericChain(@NotNull Block<T> block) {
		super(block, BlockModelDispatcher.loadDataModel("pepeethings:block/chain/knot"));
	}

	public boolean renderAttached(@NotNull TessellatorGeneral tessellator, @NotNull WorldSource worldSource, @NotNull TilePosc tilePos, boolean cullFaces, @Nullable IconCoordinate overrideTexture) {
		boolean hasFloor = worldSource.isBlockOpaqueCube(tilePos.down(new TilePos()));
		boolean hasBlockNegX = this.canConnect(worldSource, tilePos, Direction.WEST);
		boolean hasBlockPosX = this.canConnect(worldSource, tilePos, Direction.EAST);
		boolean hasBlockNegY = this.canConnect(worldSource, tilePos, Direction.DOWN) || hasFloor;
		boolean hasBlockPosY = this.canConnect(worldSource, tilePos, Direction.UP);
		boolean hasBlockNegZ = this.canConnect(worldSource, tilePos, Direction.NORTH);
		boolean hasBlockPosZ = this.canConnect(worldSource, tilePos, Direction.SOUTH);
		boolean didRender = false;
		if (hasBlockNegZ) {
			didRender |= this.line.renderAttached(this, tessellator, worldSource, tilePos, 0, 0, 0, (double)0.0F, (double)0.0F, (double)0.0F, true, cullFaces, overrideTexture);
		}

		if (hasBlockPosZ) {
			didRender |= this.line.renderAttached(this, tessellator, worldSource, tilePos, 0, 2, 0, (double)0.0F, (double)0.0F, (double)0.0F, true, cullFaces, overrideTexture);
		}

		if (hasBlockNegX) {
			didRender |= this.line.renderAttached(this, tessellator, worldSource, tilePos, 0, 1, 0, (double)0.0F, (double)0.0F, (double)0.0F, true, cullFaces, overrideTexture);
		}

		if (hasBlockPosX) {
			didRender |= this.line.renderAttached(this, tessellator, worldSource, tilePos, 0, 3, 0, (double)0.0F, (double)0.0F, (double)0.0F, true, cullFaces, overrideTexture);
		}

		if (hasBlockNegY) {
			didRender |= this.line.renderAttached(this, tessellator, worldSource, tilePos, 3, 0, 0, (double)0.0F, (double)0.0F, (double)0.0F, true, cullFaces, overrideTexture);
		}

		if (hasBlockPosY) {
			didRender |= this.line.renderAttached(this, tessellator, worldSource, tilePos, 1, 0, 0, (double)0.0F, (double)0.0F, (double)0.0F, true, cullFaces, overrideTexture);
		}

		didRender |= this.knot.renderAttached(this, tessellator, worldSource, tilePos, 0, 0, 0, (double)0.0F, (double)0.0F, (double)0.0F, false, cullFaces, overrideTexture);

		return didRender;
	}

	private boolean canConnect(@NotNull WorldSource worldSource, @NotNull TilePosc tilePos, @NotNull Direction direction) {
		TilePos shiftedPos = tilePos.add(direction, new TilePos());
		Block<?> _block = worldSource.getBlockType(shiftedPos);
		if (direction == Direction.DOWN) {
			if (Block.hasLogicClass(_block, BlockLogicLanternFirefly.class) && (worldSource.getBlockData(shiftedPos) & 1) != 0) {
				return true;
			}

			if (Block.hasLogicClass(_block, BlockLogicJarButterfly.class) && (worldSource.getBlockData(shiftedPos) & 1) != 0) {
				return true;
			}
		} else if (direction == Direction.UP && (worldSource.isBlockOpaqueCube(shiftedPos) || BlockTags.CAN_HANG_OFF.appliesTo(_block))) {
			return true;
		}

		if ((worldSource.getBlockData(tilePos) & 128) != 0 && worldSource.isBlockOpaqueCube(shiftedPos)) {
			return true;
		} else {
			return _block == this.block;
		}
	}
}
