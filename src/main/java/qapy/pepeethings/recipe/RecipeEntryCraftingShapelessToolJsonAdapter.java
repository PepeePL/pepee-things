package qapy.pepeethings.recipe;

import com.google.gson.*;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.adapter.RecipeJsonAdapter;
import net.minecraft.core.item.ItemStack;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeEntryCraftingShapelessToolJsonAdapter implements RecipeJsonAdapter<RecipeEntryCraftingShapelessTool> {

	@Override
	public RecipeEntryCraftingShapelessTool deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		List<RecipeSymbol> inputs = (List)object.get("inputs").getAsJsonArray().asList().stream().map((E) -> (RecipeSymbol)context.deserialize(E, RecipeSymbol.class)).collect(Collectors.toList());
		RecipeSymbol tool = (RecipeSymbol)context.deserialize(object.get("tool"), RecipeSymbol.class);
		ItemStack output = (ItemStack)context.deserialize(object.get("output"), ItemStack.class);
		return new RecipeEntryCraftingShapelessTool(inputs, tool, output);
	}

	public JsonElement serialize(RecipeEntryCraftingShapelessTool src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject object = new JsonObject();
		object.addProperty("name", src.toString());
		object.addProperty("type", Registries.RECIPE_TYPES.getKey(src.getClass()));
		object.add("input", context.serialize(src.input));
		object.add("output", context.serialize(src.output));
		object.add("tool", context.serialize(src.toolToUse));
		return object;
	}
}
