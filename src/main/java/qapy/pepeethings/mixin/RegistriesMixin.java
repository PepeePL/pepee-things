package qapy.pepeethings.mixin;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.Registry;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.ModBlocks;

import java.util.ArrayList;
import java.util.List;

@Mixin(Registries.class)
public class RegistriesMixin {
	@Shadow
	@Final
	public static Registry<List<ItemStack>> ITEM_GROUPS;

	@Inject(method = "init", at = @At("TAIL"))
	private void initInject(CallbackInfo ci){
		List<ItemStack> glassStackList = new ArrayList<>();
		glassStackList.add(Blocks.GLASS.getDefaultStack());
		for (DyeColor color : DyeColor.values()) {
			glassStackList.add(new ItemStack(ModBlocks.GLASS_COLORED, 1, color.blockMeta));
		}
		ITEM_GROUPS.register("pepeethings:glasses", glassStackList);

	}
}
