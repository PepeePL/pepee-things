package qapy.pepeethings.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import qapy.pepeethings.util.MossRegistry;

public class Moss extends Item {
	public Moss(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
	}

	@Override
	public boolean onUseItemOnBlock(ItemStack itemstack, Player entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		return useMoss(itemstack, entityplayer, world, blockX, blockY, blockZ);
	}

	public boolean useMoss(ItemStack itemstack, Player entityplayer, World world, int blockX, int blockY, int blockZ) {
		int blockID = world.getBlockId(blockX, blockY, blockZ);
		if(!world.isClientSide){
			Integer mossyBlockID = MossRegistry.getMossyVariant(blockID);
			if(mossyBlockID != null){
				world.setBlockWithNotify(blockX, blockY, blockZ, mossyBlockID);
				if (entityplayer == null || entityplayer.getGamemode().consumeBlocks()) {
					--itemstack.stackSize;
				}
				return true;
			}
		}
		return false;
	}
}
