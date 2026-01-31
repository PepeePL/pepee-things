package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicTransparent;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockLogicGlassColored extends BlockLogicTransparent implements IPainted {

	public BlockLogicGlassColored(Block<?> block) {
		super(block, Material.glass);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case PICK_BLOCK:
			case SILK_TOUCH:
				return new ItemStack[]{new ItemStack(this, 1, meta)};
			default:
				return null;
		}
	}

	@Override
	public int getPlacedBlockMetadata(@Nullable Player player, ItemStack stack, World world, int x, int y, int z, Side side, double xPlaced, double yPlaced) {
		return stack.getMetadata() & 15;
	}

	@Override
	public DyeColor fromMetadata(int meta) {
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
	public void removeDye(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, 0);
	}
}
