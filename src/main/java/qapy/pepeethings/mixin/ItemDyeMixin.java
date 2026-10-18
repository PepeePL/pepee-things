package qapy.pepeethings.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import qapy.pepeethings.ModItems;

import java.util.Random;

import static qapy.pepeethings.util.MossRegistry.getMossyBlocks;

@Mixin(value = ItemDye.class)
public class ItemDyeMixin {
	@Inject(method = "onUseOnBlock", at = @At(value = "NEW", target = "Lnet/minecraft/core/world/pos/TilePos;"), cancellable = true)
	private void handleMossBlocks(ItemStack selfStack, World world, Player player, TilePosc blockPos, Side side, double xPlaced, double yPlaced, CallbackInfoReturnable<Boolean> cir) {
		Block<?> block = world.getBlockType(blockPos);
		if (getMossyBlocks().contains(block)) {
			if (!world.isClientSide) {
				int randomInt = new Random().nextInt(3) + 1;
				if(player != null) {
					EntityItem entityItem = new EntityItem(world, (player.x + blockPos.x()) / 2, blockPos.y(), (player.z + blockPos.z()) / 2, new ItemStack(ModItems.MOSS, randomInt));
					entityItem.dropItem(entityItem.item, 0);
					if (player.getGamemode().hasBlockConsumption()) {
						selfStack.stackSize--;
					}
				}
				else {
					EntityItem entityItem = new EntityItem(world, blockPos.x() + 0.5, blockPos.y() + 0.5, blockPos.z() + 0.5, new ItemStack(ModItems.MOSS, randomInt));
					entityItem.dropItem(entityItem.item, 0);
					selfStack.stackSize--;
				}
			}
			cir.setReturnValue(true);
		}
	}
}
