package qapy.pepeethings.recipe;

import com.google.gson.*;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.adapter.RecipeJsonAdapter;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCraftingWithTool;
import net.minecraft.core.item.ItemStack;

import java.lang.reflect.Type;

public class RecipeEntryGrindingJsonAdapter implements RecipeJsonAdapter<RecipeEntryGrinding> {

	public RecipeEntryGrinding deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		RecipeSymbol input = context.deserialize(object.get("input"), RecipeSymbol.class);
		ItemStack output = context.deserialize(object.get("output"), ItemStack.class);
		RecipeEntryGrinding recipe = new RecipeEntryGrinding(input, output);
		return recipe;
	}

	public JsonElement serialize(RecipeEntryGrinding src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("name", src.toString());
		object.addProperty("type", Registries.RECIPE_TYPES.getKey(src.getClass()));
		object.add("input", context.serialize(src.inputSymbol));
		object.add("output", context.serialize(src.output));
		return object;
	}
}
