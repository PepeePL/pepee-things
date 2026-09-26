package qapy.pepeethings.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import qapy.pepeethings.util.ChiselRegistry;

public class ItemChisel extends Item {
	private final boolean hasDurability;
	public ItemChisel(String name, String namespaceId, int id, boolean hasDurability) {
		super(name, namespaceId, id);
		this.hasDurability = hasDurability;
		setMaxStackSize(1);
		if (hasDurability) setMaxDamage(128);
	}

	@Override
	public boolean onUseOnBlock(@NotNull ItemStack itemstack, @NotNull World world, Player player, @NotNull TilePosc blockPos, @NotNull Side side, double xHit, double yHit) {
		return chiselBlock(itemstack, player, world, blockPos);
	}

	private boolean chiselBlock(ItemStack itemstack, Player player, World world, TilePosc blockPos) {
		Block<?> blockID = world.getBlockType(blockPos);
		Block<?> nextBlock = ChiselRegistry.getNext(blockID);
		if(nextBlock == null) return false;
		if (this.hasDurability) itemstack.damageItem(1, player);
		world.setBlockTypeNotify(blockPos, nextBlock);
		world.playBlockEvent(blockPos, 2001, nextBlock.id());
		world.playSoundAtEntity(player, player, "pepeethings:item.chisel.use", 1.0f, 0.9f);
		return true;
	}
}
