package qapy.pepeethings.recipe;

import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.*;
import net.minecraft.core.data.registry.recipe.adapter.RecipeJsonAdapter;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCraftingDynamic;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.ContainerCrafting;
import qapy.pepeethings.ModItems;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class RecipeEntryGrinding extends RecipeEntryCraftingDynamic implements HasJsonAdapter {
	public RecipeSymbol inputSymbol;
	public RecipeSymbol toolToUse;
	public ItemStack output;

	public RecipeEntryGrinding(RecipeSymbol input, ItemStack output) {
		this.inputSymbol = input;
		this.output = output;
		this.toolToUse = new RecipeSymbol(new ItemStack(ModItems.MORTAR));
	}
	public RecipeEntryGrinding(){

	}

	public boolean matches(ContainerCrafting containerCrafting) {
		boolean hasMortar = false;
		boolean hasItem = false;

		for(int i = 0; i < 9; ++i) {
			ItemStack stack = containerCrafting.getItem(i);
			if (stack != null && stack.getItem().equals(toolToUse.getStack().getItem())) {
				if (hasMortar) {
					return false;
				}
				hasMortar = true;
			} else {
				if (stack != null && !this.inputSymbol.matches(stack)) {
					return false;
				}

				if (this.inputSymbol.matches(stack)) {
					hasItem = true;
				}
			}
		}

		return hasMortar && hasItem;
	}

	@Override
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
				RecipeNamespace namespace = (RecipeNamespace)Registries.RECIPES.getItem((String)query.scope.getRight());
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
			if (query.strict && this.output.getDisplayName().equalsIgnoreCase((String)query.query.getRight())) {
				return true;
			}

			if (!query.strict && this.output.getDisplayName().toLowerCase().contains(((String)query.query.getRight()).toLowerCase())) {
				return true;
			}
		} else if (query.query.getLeft() == SearchQuery.QueryType.GROUP && !Objects.equals(query.query.getRight(), "")) {
			List<ItemStack> groupStacks = (new RecipeSymbol((String)query.query.getRight())).resolve();
			if (groupStacks == null) {
				return false;
			}

			return groupStacks.contains(this.output);
		}

		return false;
	}

	public boolean matchesUsage(SearchQuery query) {
		RecipeSymbol[] symbols = new RecipeSymbol[]{this.inputSymbol, this.toolToUse};

		for(RecipeSymbol symbol : symbols) {
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

					Stream<ItemStack> var10000 = stacks.stream();
					Objects.requireNonNull(groupStacks);
					if (var10000.anyMatch(groupStacks::contains)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public ItemStack getCraftingResult(ContainerCrafting containerCrafting) {
		int items = 0;

		for(int i = 0; i < containerCrafting.getContainerSize(); ++i) {
			ItemStack itemstack = containerCrafting.getItem(i);
			if (itemstack != null && !itemstack.getItem().equals(toolToUse.getStack().getItem())) ++items;

		}

		return new ItemStack(this.output.getItem(), items);
	}
	@Override
	public ItemStack[] onCraftResult(ContainerCrafting containerCrafting) {
		int items = 0;
		for(int i = 0; i < containerCrafting.getContainerSize(); ++i) {
			ItemStack itemstack = containerCrafting.getItem(i);
			if (itemstack != null && !itemstack.getItem().equals(toolToUse.getStack().getItem())) ++items;

		}
		ItemStack[] returnStack = new ItemStack[9];
		for(int x = 0; x < 3; ++x) {
			for(int y = 0; y < 3; ++y) {
				ItemStack stack = containerCrafting.getItemStackAt(x, y);
				if (stack != null) {
					ItemStack stack2;
					if (stack.getItem().equals(toolToUse.getStack().getItem())) {
						if (stack.getMetadata() + items > stack.getMaxDamage()) {
							stack2 = null;
						} else {
							stack2 = stack.copy();
							stack2.setMetadata(stack.getMetadata() + items);
						}
					} else if (stack.stackSize - 1 == 0) {
						stack2 = null;
					} else {
						stack2 = new ItemStack(stack.getItem(), stack.stackSize - 1);
					}
					containerCrafting.setSlotContentsAt(x, y, stack2);
				}
			}
		}
		return returnStack;
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public RecipeJsonAdapter<?> getAdapter() {
		return new RecipeEntryGrindingJsonAdapter();
	}
}
