package qapy.pepeethings.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import qapy.pepeethings.util.MossRegistry;

public class ItemMoss extends Item {
	public ItemMoss(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
	}

	@Override
	public boolean onUseOnBlock(ItemStack itemstack, World world, Player player, TilePosc posc, Side side, double xPlaced, double yPlaced) {
		return useMoss(itemstack, player, world, posc.x(), posc.y(), posc.z());
	}

	public boolean useMoss(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ) {
		int blockID = world.getBlockId(blockX, blockY, blockZ);
		if(!world.isClientSide){
			Integer mossyBlockID = MossRegistry.getMossyVariant(blockID);
			if(mossyBlockID != null){
				world.setBlockWithNotify(blockX, blockY, blockZ, mossyBlockID);
				if (player == null || player.getGamemode().hasBlockConsumption()) {
					--itemstack.stackSize;
				}
				return true;
			}
		}
		return false;
	}
}
