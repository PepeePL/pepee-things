package qapy.pepeethings.client.model;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import qapy.pepeethings.block.entity.TileEntityCrate;

public class BlockModelCrate<T extends BlockLogic> extends BlockModelStandard<T> {
	private IconCoordinate crateSides;
	private IconCoordinate crateTopEmpty;
	private IconCoordinate[] crateTopApple;
	public BlockModelCrate(Block<T> block) {
		super(block);
		this.crateSides = TextureRegistry.getTexture("pepeethings:block/crate/side");
		this.crateTopEmpty = TextureRegistry.getTexture("pepeethings:block/crate/top");
		this.crateTopApple = new IconCoordinate[]{
				TextureRegistry.getTexture("pepeethings:block/crate/apple/1"),
				TextureRegistry.getTexture("pepeethings:block/crate/apple/2"),
		};
	}

	@Override
	public IconCoordinate getBlockTexture(WorldSource blockAccess, int x, int y, int z, Side side) {
		if (side == Side.TOP) {
			TileEntityCrate te = (TileEntityCrate) blockAccess.getTileEntity(x, y, z);
//			if (te.getStoredItem() == Items.FOOD_APPLE){
//				int appleCount = te.getCount();
//				return crateTopApple[appleCount-1];
//			}
			return crateTopEmpty;
		}else {
			return crateSides;
		}
	}
}
