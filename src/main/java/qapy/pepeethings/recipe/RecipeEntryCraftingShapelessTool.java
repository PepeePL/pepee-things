package qapy.pepeethings.recipe;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.*;
import net.minecraft.core.data.registry.recipe.adapter.RecipeJsonAdapter;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;

import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.ContainerCrafting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class RecipeEntryCraftingShapelessTool extends RecipeEntryCrafting<List<RecipeSymbol>, ItemStack> implements HasJsonAdapter {
	public List<RecipeSymbol> input;
	public RecipeSymbol toolToUse;
	public ItemStack output;

	public RecipeEntryCraftingShapelessTool(List<RecipeSymbol> input, RecipeSymbol toolToUse, ItemStack output){
		super(addTool(input, toolToUse), output);
	}

	public RecipeEntryCraftingShapelessTool(){
	}

	private static List<RecipeSymbol> addTool(List<RecipeSymbol> input, RecipeSymbol toolToUse) {
		List<RecipeSymbol> result = new ArrayList<>(input);
		result.add(toolToUse);
		return result;
	}

	public boolean matches(ContainerCrafting containerCrafting) {
		ArrayList<RecipeSymbol> arraylist = new ArrayList((Collection)this.getInput());

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				ItemStack itemstack = containerCrafting.getItemStackAt(j, i);
				if (itemstack != null) {
					boolean flag = false;

					for(RecipeSymbol recipeSymbol : arraylist) {
						if (recipeSymbol.matches(itemstack)) {
							flag = true;
							arraylist.remove(recipeSymbol);
							break;
						}
					}

					if (!flag) {
						return false;
					}
				}
			}
		}

		return arraylist.isEmpty();
	}

	public boolean matchesQuery(SearchQuery query) {
		switch (query.mode) {
			case ALL:
				if ((this.matchesRecipe(query) || this.matchesUsage(query)) && this.matchesScope(query)) {
					return true;
				}
				break;
			case RECIPE:
				if (this.matchesRecipe(query) && this.matchesScope(query)) {
					return true;
				}
				break;
			case USAGE:
				if (this.matchesUsage(query) && this.matchesScope(query)) {
					return true;
				}
		}

		return false;
	}

	public boolean matchesScope(SearchQuery query) {
		if (query.scope.getLeft() == SearchQuery.SearchScope.NONE) {
			return true;
		} else {
			if (query.scope.getLeft() == SearchQuery.SearchScope.NAMESPACE) {
				RecipeNamespace namespace = (RecipeNamespace) Registries.RECIPES.getItem((String)query.scope.getRight());
				if (namespace == this.parent.getParent()) {
					return true;
				}
			} else if (query.scope.getLeft() == SearchQuery.SearchScope.NAMESPACE_GROUP) {
				RecipeGroup group;
				try {
					group = Registries.RECIPES.getGroupFromKey((String)query.scope.getRight());
				} catch (IllegalArgumentException var4) {
					group = null;
				}

				if (group == this.parent) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean matchesRecipe(SearchQuery query) {
		if (query.query.getLeft() == SearchQuery.QueryType.NAME) {
			if (query.strict && ((ItemStack)this.getOutput()).getDisplayName().equalsIgnoreCase((String)query.query.getRight())) {
				return true;
			}

			if (!query.strict && ((ItemStack)this.getOutput()).getDisplayName().toLowerCase().contains(((String)query.query.getRight()).toLowerCase())) {
				return true;
			}
		} else if (query.query.getLeft() == SearchQuery.QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
			List<ItemStack> groupStacks = (new RecipeSymbol((String)query.query.getRight())).resolve();
			if (groupStacks == null) {
				return false;
			}

			return groupStacks.contains(this.getOutput());
		}

		return false;
	}

	public boolean matchesUsage(SearchQuery query) {
		for(RecipeSymbol symbol : this.getInput()) {
			if (symbol != null) {
				List<ItemStack> stacks = symbol.resolve();
				if (query.query.getLeft() == SearchQuery.QueryType.NAME) {
					for(ItemStack stack : stacks) {
						if (query.strict && stack.getDisplayName().equalsIgnoreCase((String)query.query.getRight())) {
							return true;
						}

						if (!query.strict && stack.getDisplayName().toLowerCase().contains(((String)query.query.getRight()).toLowerCase())) {
							return true;
						}
					}
				} else if (query.query.getLeft() == SearchQuery.QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
					List<ItemStack> groupStacks = (new RecipeSymbol((String)query.query.getRight())).resolve();
					if (groupStacks == null) {
						return false;
					}

					Stream var10000 = stacks.stream();
					Objects.requireNonNull(groupStacks);
					if (var10000.anyMatch(groupStacks::contains)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public ItemStack getCraftingResult(ContainerCrafting containerCrafting) {
		return ((ItemStack)this.getOutput()).copy();
	}

	public int getRecipeSize() {
		return ((List)this.getInput()).size();
	}

	@Override
	public RecipeJsonAdapter<?> getAdapter() {
		return new RecipeEntryCraftingShapelessToolJsonAdapter();
	}
}
