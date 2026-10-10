package qapy.pepeethings.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qapy.pepeethings.util.MossRegistry;

public class ItemMoss extends Item {
	public ItemMoss(String name, String namespaceId, int id) {
		super(name, namespaceId, id);
	}

	@Override
	public boolean onUseOnBlock(@NotNull ItemStack selfStack, @NotNull World world, @Nullable Player player, @NotNull TilePosc blockPos, @NotNull Side side, double xHit, double yHit) {
		return useMoss(selfStack, player, world, blockPos);
	}

	public boolean useMoss(ItemStack itemstack, Player player, World world, TilePosc blockPos) {
		Block<?> block = world.getBlockType(blockPos);
		if(!world.isClientSide){
			Block<?> mossyBlock = MossRegistry.getMossyVariant(block);
			if(mossyBlock != null){
				world.setBlockTypeNotify(blockPos, mossyBlock);
				if (player == null || player.getGamemode().hasBlockConsumption()) {
					--itemstack.stackSize;
				}
				return true;
			}
		}
		return false;
	}
}
