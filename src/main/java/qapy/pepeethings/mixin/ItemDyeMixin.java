package qapy.pepeethings.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemDye;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import qapy.pepeethings.ModItems;

import java.util.Random;

import static qapy.pepeethings.util.MossRegistry.getMossyBlocks;

@Mixin(value = ItemDye.class, remap = false)
public class ItemDyeMixin {
	@Inject(method = "onUseItemOnBlock", at = @At(value = "RETURN", ordinal = 2), cancellable = true)
	private void handleMossBlocks(ItemStack itemStack, Player player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced, CallbackInfoReturnable<Boolean> cir) {
		Block<?> block = world.getBlock(blockX, blockY, blockZ);
		if (block == null) return;
		if (getMossyBlocks().contains(block.id())) {
			if (!world.isClientSide) {
				int randomInt = new Random().nextInt(3) + 1;
				EntityItem entityItem = new EntityItem(world, blockX + 0.5, blockY + 1.0, blockZ + 0.5, new ItemStack(ModItems.MOSS, randomInt));
				entityItem.dropItem(entityItem.item, 0);
				if (player == null || player.getGamemode().consumeBlocks()) {
					--itemStack.stackSize;
				}
			}
			cir.setReturnValue(true);
		}
	}
}
