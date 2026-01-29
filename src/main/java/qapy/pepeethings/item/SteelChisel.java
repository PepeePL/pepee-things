package qapy.pepeethings.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import qapy.pepeethings.util.ChiselRegistry;

public class SteelChisel extends Item {
	public SteelChisel(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
		setMaxStackSize(1);
	}

	@Override
	public boolean onUseItemOnBlock(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		return chiselBlock(player, world, blockX, blockY, blockZ);
	}
	private boolean chiselBlock(Player player, World world, int blockX, int blockY, int blockZ) {
		int blockID = world.getBlockId(blockX, blockY, blockZ);
		if(!world.isClientSide){
			Integer nextBlockID = ChiselRegistry.getNext(blockID);
			if(nextBlockID == null){
				return false;
			}
			world.setBlockWithNotify(blockX, blockY, blockZ, nextBlockID);
			world.playBlockEvent(2001, blockX, blockY, blockZ, nextBlockID);
			world.playSoundAtEntity(player, player, "pepeethings:item.chisel.use", 1.0f, 0.9f);
			return true;
		}
		return false;
	}
}
