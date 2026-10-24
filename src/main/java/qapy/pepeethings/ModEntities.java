package qapy.pepeethings;

import net.minecraft.core.util.collection.NamespaceID;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import turniplabs.halplibe.helper.EntityHelper;

import static qapy.pepeethings.PepeeThingsMod.MOD_ID;

public class ModEntities {
	public void initEntities() {
		EntityHelper.addMapping(TileEntityFurnacePorcelain.class, new NamespaceID(MOD_ID, "furnace_porcelain"));
	}
}
