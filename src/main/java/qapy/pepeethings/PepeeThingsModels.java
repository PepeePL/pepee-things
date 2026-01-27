package qapy.pepeethings;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

public class PepeeThingsModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		ModelHelper.setItemModel(ModItems.CHISEL, () -> new ItemModelStandard(ModItems.CHISEL, null).setIcon("pepeethings:item/chisel"));
		ModelHelper.setItemModel(ModItems.CHISEL_STEEL, () -> new ItemModelStandard(ModItems.CHISEL_STEEL, null).setIcon("pepeethings:item/chisel_steel"));
		ModelHelper.setItemModel(ModItems.MOSS, () -> new ItemModelStandard(ModItems.MOSS, null).setIcon("pepeethings:item/moss"));

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
