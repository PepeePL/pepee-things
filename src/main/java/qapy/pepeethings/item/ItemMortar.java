package qapy.pepeethings.item;

import net.minecraft.core.item.Item;
import org.jetbrains.annotations.NotNull;

public class ItemMortar extends Item {
	public ItemMortar(@NotNull String translationKey, @NotNull String namespaceId, int id) {
		super(translationKey, namespaceId, id);
		this.setMaxStackSize(1);
		this.setMaxDamage(127);
	}
}
