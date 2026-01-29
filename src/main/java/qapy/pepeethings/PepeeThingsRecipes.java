package qapy.pepeethings;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Items;
import qapy.pepeethings.util.RecipeBuilderDyeing;
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
		RecipeBuilderShaped hammerRecipe = new RecipeBuilderShaped(MOD_ID, "II", "IIS", "II" );
		hammerRecipe.addInput('S', Items.STICK).addInput('I', Blocks.COBBLE_STONE.asItem()).create("tool_hammer_stone", ModItems.TOOL_HAMMER_STONE.getDefaultStack());
		hammerRecipe.addInput('S', Items.STICK).addInput('I', Items.INGOT_IRON).create("tool_hammer_iron", ModItems.TOOL_HAMMER_IRON.getDefaultStack());
		hammerRecipe.addInput('S', Items.STICK).addInput('I', Items.INGOT_GOLD).create("tool_hammer_gold", ModItems.TOOL_HAMMER_GOLD.getDefaultStack());
		hammerRecipe.addInput('S', Items.STICK).addInput('I', Items.DIAMOND).create("tool_hammer_diamond", ModItems.TOOL_HAMMER_DIAMOND.getDefaultStack());
		hammerRecipe.addInput('S', Items.STICK).addInput('I', Items.INGOT_STEEL).create("tool_hammer_steel", ModItems.TOOL_HAMMER_STEEL.getDefaultStack());
		RecipeBuilderShaped netRecipe = new RecipeBuilderShaped(MOD_ID, "  W", " SW", "S " );
		netRecipe.addInput('S', Items.STICK).addInput('W', "minecraft:wools").create("net", ModItems.NET.getDefaultStack());
		RecipeBuilderDyeing glassDyeing = new RecipeBuilderDyeing(MOD_ID);
		glassDyeing.setInput("pepeethings:glasses").create("glass_dyeing", ModBlocks.GLASS_COLORED);
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

	}
}
