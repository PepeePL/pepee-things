package qapy.pepeethings.mixin;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.CreativeMenuContents;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.ModBlocks;

import java.util.List;

@Mixin(value = CreativeMenuContents.class)
public abstract class CreativeMenuContentsMixin{

	@Shadow
	@NotNull
	private static IPainted painted(@NotNull Block<?> block) {
		throw new UnsupportedOperationException("Implemented via mixin");
	}

	@Inject(method = "addPainted", at = @At("TAIL"))
	private static void addPainted(@NotNull List<ItemStack> list, DyeColor color, CallbackInfo ci){
		list.add(new ItemStack(ModBlocks.GLASS_COLORED, 1, painted(ModBlocks.GLASS_COLORED).toMetadata(color)));
		list.add(new ItemStack(ModBlocks.CONCRETE_POWDER, 1, painted(ModBlocks.CONCRETE_POWDER).toMetadata(color)));
		list.add(new ItemStack(ModBlocks.CONCRETE, 1, painted(ModBlocks.CONCRETE).toMetadata(color)));
		list.add(new ItemStack(ModBlocks.SLAB_CONCRETE, 1, painted(ModBlocks.SLAB_CONCRETE).toMetadata(color)));
		list.add(new ItemStack(ModBlocks.STAIRS_CONCRETE, 1, painted(ModBlocks.STAIRS_CONCRETE).toMetadata(color)));
	}
}
