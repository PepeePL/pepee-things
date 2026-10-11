package qapy.pepeethings.client.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.guidebook.SlotGuidebook;
import net.minecraft.client.gui.guidebook.crafting.displays.RecipeDisplayAdapter;
import net.minecraft.core.data.registry.recipe.RecipeEntryBase;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.item.ItemStack;
import qapy.pepeethings.recipe.RecipeEntryGrinding;

@Environment(EnvType.CLIENT)
public class DisplayAdapterGrinding implements RecipeDisplayAdapter<RecipeEntryGrinding> {
	public DisplayAdapterGrinding() {
	}

	public List<SlotGuidebook> getSlots(RecipeEntryGrinding recipe, int recipeAmount, int xOffset, int yOffset) {
		List<SlotGuidebook> recipeSlots = new ArrayList();
		RecipeSymbol[] symbols = new RecipeSymbol[]{recipe.inputSymbol, recipe.toolToUse, null, null, new RecipeSymbol(recipe.output)};

		for(int i = 0; i < 4; ++i) {
			int x = 13 + 18 * (i % 2) + xOffset;
			int y = 10 + 18 * (i / 2 + recipeAmount * 3) + yOffset;
			SlotGuidebook slot;
			if (symbols[i] == recipe.toolToUse) {
				slot = new SlotGuidebookTool(i, x, y, symbols[i], false, recipe);
			} else {
				slot = new SlotGuidebook(i, x, y, symbols[i], false, recipe);
			}

			recipeSlots.add(slot);
		}

		int centerY = (((SlotGuidebook)recipeSlots.get(recipeSlots.size() - 1)).y + ((SlotGuidebook)recipeSlots.get(recipeSlots.size() - 3)).y) / 2;
		recipeSlots.add((new SlotGuidebook(symbols.length - 1, 81 + xOffset, centerY, symbols[4], false, recipe)).setAsOutput());
		return recipeSlots;
	}

	@Environment(EnvType.CLIENT)
	public static class SlotGuidebookTool extends SlotGuidebook {
		public SlotGuidebookTool(int id, int x, int y, RecipeSymbol symbol, boolean discovered, RecipeEntryBase<?, ?, ?> recipe) {
			super(id, x, y, symbol, discovered, recipe);
		}

		public void showRandomItem() {
			Random r = new Random();
			if (this.symbol != null && this.symbol.getItemGroup() != null) {
				List<ItemStack> list = this.symbol.resolve();
				ItemStack newItem = (ItemStack)list.get(r.nextInt(list.size()));
				if (list.size() > 1) {
					while(newItem == this.item) {
						newItem = (ItemStack)list.get(r.nextInt(list.size()));
					}
				}

				this.item = new ItemStack(newItem);
			}

			this.item.setMetadata(r.nextInt(this.item.getMaxDamage()));
		}
	}
}
