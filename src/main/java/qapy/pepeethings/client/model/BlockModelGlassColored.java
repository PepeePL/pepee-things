package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelTransparent;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelGlassColored<T extends BlockLogic> extends BlockModelTransparent<T> {
	public static final IconCoordinate[] texCoords = new IconCoordinate[16];
	public BlockModelGlassColored(Block<T> block, boolean renderInside) {
		super(block, renderInside);
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return texCoords[data & 15];
	}

	static {
		for(DyeColor c : DyeColor.blockOrderedColors()) {
			texCoords[c.blockMeta] = TextureRegistry.getTexture("pepeethings:block/glass/" + c.colorID);
		}
	}
}
