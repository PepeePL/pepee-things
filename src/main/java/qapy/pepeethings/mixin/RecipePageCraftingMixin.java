package qapy.pepeethings.mixin;

import net.minecraft.client.gui.guidebook.crafting.RecipePageCrafting;
import net.minecraft.client.gui.guidebook.crafting.displays.RecipeDisplayAdapter;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.client.gui.DisplayAdapterGrinding;
import qapy.pepeethings.recipe.RecipeEntryGrinding;

import java.util.Map;

@Mixin(RecipePageCrafting.class)
public class RecipePageCraftingMixin {
	@Shadow
	public static Map<Class<? extends RecipeEntryCrafting<?, ?>>, RecipeDisplayAdapter<?>> recipeToDisplayAdapterMap;
	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void init(CallbackInfo ci){
		recipeToDisplayAdapterMap.put(RecipeEntryGrinding.class, new DisplayAdapterGrinding());
	}
}
