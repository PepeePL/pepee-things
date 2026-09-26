package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ItemModelNet extends ItemModelStandard {
	public static IconCoordinate[] netVariants = new IconCoordinate[2];
	public ItemModelNet(Item item) {
		super(item);
	}
	public @NotNull IconCoordinate getIcon(@Nullable Entity entity, ItemStack itemStack) {
		int meta = itemStack.getMetadata();
		if (meta == 1) {
			return netVariants[1];
		} else {
			return netVariants[0];
		}
	}

	static {
			netVariants[0] = TextureRegistry.getTexture("pepeethings:item/net");
			netVariants[1] = TextureRegistry.getTexture("pepeethings:item/net_full");
	}
}
