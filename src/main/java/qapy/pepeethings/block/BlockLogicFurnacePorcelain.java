package qapy.pepeethings.block;

import com.mojang.logging.LogUtils;
import net.minecraft.core.Global;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicRotatable;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import qapy.pepeethings.ModBlocks;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import qapy.pepeethings.util.IPlayer;

import java.util.Random;

public class BlockLogicFurnacePorcelain extends BlockLogicRotatable {
	private static final Logger LOGGER = LogUtils.getLogger();
	protected final boolean isActive;

	public BlockLogicFurnacePorcelain(Block<?> block, boolean active) {
		super(block, Materials.STONE);
		this.isActive = active;
		block.withEntity(TileEntityFurnacePorcelain::new);
	}

	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		return switch (dropCause) {
			case PICK_BLOCK, EXPLOSION, PROPER_TOOL, SILK_TOUCH, PISTON_CRUSH ->
				new ItemStack[]{new ItemStack(ModBlocks.PORCELAIN_FURNACE_IDLE)};
			default -> null;
		};
	}

	public void animationTick(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Random rand) {
		if (this.isActive) {
			double poxX = (double)tilePos.x() + (double)0.5F;
			double posY = (double)tilePos.y() + (double)0.0F + (double)(rand.nextFloat() * 6.0F / 16.0F);
			double posZ = (double)tilePos.z() + (double)0.5F;
			double f3 = 0.52F;
			double f4 = (rand.nextFloat() * 0.6F - 0.3F);
			switch (BlockLogicRotatable.getDirectionFromMeta(world.getBlockData(tilePos))) {
				case WEST:
					world.spawnParticle("smoke", poxX - f3, posY, posZ + f4, 0.0F, 0.0F, 0.0F, 0, false);
					world.spawnParticle("flame", poxX - f3, posY, posZ + f4, 0.0F, 0.0F, 0.0F, 0, false);
					break;
				case EAST:
					world.spawnParticle("smoke", poxX + f3, posY, posZ + f4, 0.0F, 0.0F, 0.0F, 0, false);
					world.spawnParticle("flame", poxX + f3, posY, posZ + f4, 0.0F, 0.0F, 0.0F, 0, false);
					break;
				case NORTH:
					world.spawnParticle("smoke", poxX + f4, posY, posZ - f3, 0.0F, 0.0F, 0.0F, 0, false);
					world.spawnParticle("flame", poxX + f4, posY, posZ - f3, 0.0F, 0.0F, 0.0F, 0, false);
					break;
				case SOUTH:
					world.spawnParticle("smoke", poxX + f4, posY, posZ + f3, 0.0F, 0.0F, 0.0F, 0, false);
					world.spawnParticle("flame", poxX + f4, posY, posZ + f3, 0.0F, 0.0F, 0.0F, 0, false);
			}

		}
	}

	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		if (!world.isClientSide) {
			TileEntity var10 = world.getTileEntity(tilePos);
			if (var10 instanceof TileEntityFurnacePorcelain furnace) {
				((IPlayer) player).displayFurnacePorcelainScreen(furnace);
			}
		}
		return true;
	}

	public static void updateFurnaceBlockState(@NotNull World world, @NotNull TilePos tilePos, boolean lit) {
		if (!(world.getTileEntity(tilePos) instanceof TileEntityFurnacePorcelain)) {
			String msg = "Furnace is missing Tile Entity at " + tilePos + ", block will be removed!";
			if (Global.BUILD_CHANNEL.isUnstableBuild()) {
				throw new RuntimeException(msg);
			} else {
				world.setBlockTypeNotify(tilePos, Blocks.AIR);
				LOGGER.warn(msg);
			}
		} else {
			int meta = world.getBlockData(tilePos);
			Block<? extends BlockLogic> block = lit ? ModBlocks.PORCELAIN_FURNACE_ACTIVE : ModBlocks.PORCELAIN_FURNACE_IDLE;
			world.setBlockTypeDataRaw(tilePos, block, meta);
			world.notifyBlockChange(tilePos, block);
		}
	}
}
