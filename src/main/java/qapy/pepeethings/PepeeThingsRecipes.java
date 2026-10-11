package qapy.pepeethings;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DyeColor;
import qapy.pepeethings.recipe.RecipeEntryGrinding;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShapeless;

import java.util.ArrayList;
import java.util.List;

import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class PepeeThingsRecipes {
	public static void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}

	public static void onRecipesReady() {
		registerGroups();
		DataLoader.loadRecipesFromFile("/assets/" + MOD_ID + "/recipes/workbench.json");
		DataLoader.loadRecipesFromFile("/assets/" + MOD_ID + "/recipes/furnace.json");
		DataLoader.loadRecipesFromFile("/assets/minecraft/recipes/furnace.json");
		RecipeBuilderShaped netRecipe = new RecipeBuilderShaped(MOD_ID, "  W", " SW", "S " );
		netRecipe.addInput('S', Items.STICK).addInput('W', "minecraft:wools").create("net", ModItems.NET.getDefaultStack());
		RecipeBuilderShaped chainRecipe = new RecipeBuilderShaped(MOD_ID, "S", "S");
		chainRecipe.addInput('S', Items.CHAINLINK).create("chain", new ItemStack(ModItems.CHAIN, 8));
		RecipeBuilderFurnace potatoBakedRecipe = new RecipeBuilderFurnace(MOD_ID);
		potatoBakedRecipe.setInput(ModItems.POTATO).create("potato_baked", ModItems.POTATO_BAKED.getDefaultStack());
		RecipeBuilderShaped carrotIronRecipe = new RecipeBuilderShaped(MOD_ID, "III", "ICI", "III");
		carrotIronRecipe.addInput('C', ModItems.CARROT).addInput('I', Items.INGOT_IRON).create("carrot_iron", ModItems.CARROT_IRON.getDefaultStack());
		RecipeBuilderShapeless sandwichMeatRecipe = new RecipeBuilderShapeless(MOD_ID);
		sandwichMeatRecipe.addInput(Items.FOOD_BREAD).addInput(Items.FOOD_PORKCHOP_COOKED).create("sandwich_meat", ModItems.SANDWICH_MEAT.getDefaultStack());
		RecipeBuilderShapeless sandwichTomatoRecipe = new RecipeBuilderShapeless(MOD_ID);
		sandwichTomatoRecipe.addInput(Items.FOOD_BREAD).addInput(ModItems.TOMATO).create("sandwich_tomato", ModItems.SANDWICH_TOMATO.getDefaultStack());
		RecipeBuilderShapeless stewMeatRecipe = new RecipeBuilderShapeless(MOD_ID);
		stewMeatRecipe.addInput(Items.BOWL).addInput(Items.FOOD_PORKCHOP_COOKED).addInput(ModItems.CARROT).addInput(ModItems.POTATO).create("stew_meat", ModItems.STEW_MEAT.getDefaultStack());
		RecipeBuilderShapeless soupTomatoRecipe = new RecipeBuilderShapeless(MOD_ID);
		soupTomatoRecipe.addInput(Items.BOWL).addInput(ModItems.TOMATO).addInput(ModItems.TOMATO).create("soup_tomato", ModItems.SOUP_TOMATO.getDefaultStack());
		RecipeBuilderShaped mortarRecipe = new RecipeBuilderShaped(MOD_ID, " I ", "SIS", "SSS");
		mortarRecipe.addInput('S', Blocks.STONE).addInput('I', Items.INGOT_IRON).create("mortar", ModItems.MORTAR.getDefaultStack());
		RecipeBuilderShaped concretePowderRecipe = new RecipeBuilderShaped(MOD_ID, "SKG", "SRG", "SKG");
		concretePowderRecipe.addInput('S', "pepeethings:sands").addInput('K', ModItems.CLAY_WHITE).addInput('G', "pepeethings:gravels").addInput('R', ModItems.CLAY_RED).create("concrete_powder", new ItemStack(ModBlocks.CONCRETE_POWDER, 8, 8));
	}

	private static void registerGroups(){
		Registries.RECIPE_TYPES.register("pepeethings:crafting/grinding", RecipeEntryGrinding.class);
//		Registries.RECIPE_TYPES.register("pepeethings:crafting/shapeless_tool", RecipeEntryCraftingShapelessTool.class);
		List<ItemStack> glassStackList = new ArrayList<>();
		glassStackList.add(Blocks.GLASS.getDefaultStack());
		for (DyeColor color : DyeColor.values()) {
			glassStackList.add(new ItemStack(ModBlocks.GLASS_COLORED, 1, color.blockMeta));
		}
		List<ItemStack> concretePowders = new ArrayList<>();
		for (DyeColor color : DyeColor.values()) {
			concretePowders.add(new ItemStack(ModBlocks.CONCRETE_POWDER, 1, color.blockMeta));
		}
		Registries.ITEM_GROUPS.register("pepeethings:glasses", glassStackList);
		Registries.ITEM_GROUPS.register("pepeethings:concrete_powders", concretePowders);
		Registries.ITEM_GROUPS.register("pepeethings:gravels", List.of(
			Blocks.GRAVEL.getDefaultStack(),
			ModBlocks.GRAVEL_GRANITE.getDefaultStack(),
			ModBlocks.GRAVEL_PERMAFROST.getDefaultStack(),
			ModBlocks.GRAVEL_BASALT.getDefaultStack(),
			ModBlocks.GRAVEL_LIMESTONE.getDefaultStack()));
		Registries.ITEM_GROUPS.register("pepeethings:sands", List.of(
			Blocks.SAND.getDefaultStack(),
			ModBlocks.SAND_GRANITE.getDefaultStack(),
			ModBlocks.SAND_PERMAFROST.getDefaultStack(),
			ModBlocks.SAND_BASALT.getDefaultStack(),
			ModBlocks.SAND_ROCKY.getDefaultStack()));
	}
}
