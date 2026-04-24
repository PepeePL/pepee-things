package qapy.pepeethings.mixin;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.tool.ItemToolHoe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import qapy.pepeethings.util.SeedsRegistry;

@Mixin(value = ItemToolHoe.class, remap = false)
public abstract class ItemToolHoeMixin {
	@Redirect(method = "till",
			at = @At(
				value = "NEW",
				target = "(Lnet/minecraft/core/item/Item;)Lnet/minecraft/core/item/ItemStack;"
			)
	)
	private ItemStack redirectSeedsTill(Item item){
		if(item == Items.SEEDS_WHEAT){
			return new ItemStack(SeedsRegistry.getRandomSeed());
		}
		return new ItemStack(item);
	}

	@Redirect(method = "onBlockDestroyed",
		at = @At(
			value = "NEW",
			target = "(Lnet/minecraft/core/item/Item;)Lnet/minecraft/core/item/ItemStack;"
		)
	)
	private ItemStack redirectSeedsBreak(Item item){
		if(item == Items.SEEDS_WHEAT){
			return new ItemStack(SeedsRegistry.getRandomSeed());
		}
		return new ItemStack(item);
	}
}
