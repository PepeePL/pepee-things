package qapy.pepeethings.util;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryDyeing;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBase;

import java.util.ArrayList;
import java.util.List;


public class RecipeBuilderDyeing extends RecipeBuilderBase {
	private List<RecipeSymbol> recipeSymbol = new ArrayList<>();
	public RecipeBuilderDyeing(String modID) {
		super(modID);
	}
	public RecipeBuilderDyeing setInput(RecipeSymbol symbol) {
		RecipeBuilderDyeing builder = this.clone(this);
		recipeSymbol.add(symbol);
		return builder;
	}
	public RecipeBuilderDyeing setInput(String itemGroup){
		return setInput(new RecipeSymbol(itemGroup));
	}

	public RecipeBuilderDyeing setInput(ItemStack stack){
		return setInput(new RecipeSymbol(stack));
	}

	@Override
	public void create(String recipeID, ItemStack outputStack) {
		((RecipeGroup<RecipeEntryCrafting<?, ?>>) RecipeBuilder.getRecipeGroup(modID, "workbench", new RecipeSymbol(Blocks.WORKBENCH.getDefaultStack())))
			.register(recipeID, new RecipeEntryDyeing(recipeSymbol.get(0), outputStack, false, false));
	}
	public void create(String recipeID, ItemStack outputStack, boolean useUpperMeta, boolean useItemMeta) {
		((RecipeGroup<RecipeEntryCrafting<?, ?>>) RecipeBuilder.getRecipeGroup(modID, "workbench", new RecipeSymbol(Blocks.WORKBENCH.getDefaultStack())))
			.register(recipeID, new RecipeEntryDyeing(recipeSymbol.get(0), outputStack, useUpperMeta, useItemMeta));
	}
}
