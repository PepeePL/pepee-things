package qapy.pepeethings.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import qapy.pepeethings.util.ChiselRegistry;

public class Chisel extends Item {
	private final boolean hasDurability;
	public Chisel(String name, String namespaceId, int id, boolean hasDurability) {
		super(name, namespaceId, id);
		this.hasDurability = hasDurability;
		setMaxStackSize(1);
		if (hasDurability) setMaxDamage(128);
	}

	@Override
	public boolean onUseItemOnBlock(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		return chiselBlock(itemstack, player, world, blockX, blockY, blockZ);
	}

	private boolean chiselBlock(ItemStack itemstack, Player player, World world, int blockX, int blockY, int blockZ) {
		int blockID = world.getBlockId(blockX, blockY, blockZ);
			Integer nextBlockID = ChiselRegistry.getNext(blockID);
			if(nextBlockID == null) return false;
			if (this.hasDurability) itemstack.damageItem(1, player);
			world.setBlockWithNotify(blockX, blockY, blockZ, nextBlockID);
			world.playBlockEvent(2001, blockX, blockY, blockZ, nextBlockID);
			world.playSoundAtEntity(player, player, "pepeethings:item.chisel.use", 1.0f, 0.9f);
			return true;
	}
}
