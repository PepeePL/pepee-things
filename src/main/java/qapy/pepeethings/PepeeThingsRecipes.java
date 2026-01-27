package qapy.pepeethings;

import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class PepeeThingsRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		RecipeBuilderShaped chiselRecipe = new RecipeBuilderShaped(MOD_ID, "II", "SI" );
		chiselRecipe.addInput('S', Items.STICK).addInput('I', Items.INGOT_IRON).create("chisel", ModItems.CHISEL.getDefaultStack());
		chiselRecipe.addInput('S', Items.STICK).addInput('I', Items.INGOT_STEEL).create("chisel_steel", ModItems.CHISEL_STEEL.getDefaultStack());
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

	}
}
