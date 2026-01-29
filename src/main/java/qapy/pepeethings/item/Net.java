package qapy.pepeethings.item;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityDispatcher;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.HitResult;
import net.minecraft.core.world.World;

public class Net extends Item {
	public Net(String translationKey, String namespaceId, int id) {
		super(translationKey, namespaceId, id);
		this.setMaxStackSize(1);
	}
	@Override
	public boolean onUseItemOnBlock(ItemStack itemStack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if(itemStack.getMetadata() == 1){
			itemStack.setMetadata(0);
			double reachDistance = player.getGamemode().getBlockReachDistance();
			HitResult rayTraceResult = player.rayTrace(reachDistance, 1.0F, false, false);
			if (rayTraceResult != null) {
				if (!world.isClientSide) {
					this.spawnEntity(itemStack, world, rayTraceResult.location.x, rayTraceResult.location.y, rayTraceResult.location.z);
					CompoundTag tag = new CompoundTag();
					itemStack.setData(tag);
					return true;
				}
			}
		}
		return false;
	}
	public void spawnEntity(ItemStack itemStack, World world, double x, double y, double z) {
		Entity entity = EntityDispatcher.createEntityFromNBT(itemStack.getData(), world);
		if (entity != null) {
			entity.setPos(x, y, z);
			entity.spawnInit();
			world.entityJoinedWorld(entity);
		}

	}
	@Override
	public String getLanguageKey(ItemStack itemstack) {
		return itemstack.getMetadata() == 1 ? "item.pepeethings.net_full" : "item.pepeethings.net";
	}
}
