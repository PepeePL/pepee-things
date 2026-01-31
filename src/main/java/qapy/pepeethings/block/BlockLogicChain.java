package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRope;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemToolShears;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import qapy.pepeethings.ModItems;

public class BlockLogicChain extends BlockLogicRope {
	public BlockLogicChain(Block<?> block) {
		super(block);
		this.material = Material.metal;
	}

	@Override
	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xPlaced, double yPlaced) {
		ItemStack heldItem = player.getHeldItem();
		if (heldItem != null && heldItem.getItem() instanceof ItemToolShears) {
			int meta = world.getBlockMetadata(x, y, z);
			int forceRope = ~meta & 128;
			world.setBlockMetadataWithNotify(x, y, z, forceRope | meta & -129);
			heldItem.damageItem(1, player);
			if (heldItem.stackSize <= 0) {
				player.destroyCurrentEquippedItem();
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(ModItems.CHAIN)};
	}
}
