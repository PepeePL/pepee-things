package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapHelper;
import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelCrops<T extends BlockLogic> extends BlockModelStandard<T> {
	public final IconCoordinate[] growthStageTextures;

	public BlockModelCrops(Block<T> block, String cropName) {
		super(block);
		growthStageTextures = new IconCoordinate[8];
		for (int i = 0; i <= 7; i++) {
			growthStageTextures[i] = TextureRegistry.getTexture(String.format("pepeethings:block/%s/stage" + i, cropName));
		}
	}

	public boolean render(Tessellator tessellator, int x, int y, int z) {
		float brightness = 1.0F;
		if (LightmapHelper.isLightmapEnabled()) {
			tessellator.setLightmapCoord(this.block.getLightmapCoord(renderBlocks.blockAccess, x, y, z));
		} else {
			brightness = this.getBlockBrightness(renderBlocks.blockAccess, x, y, z);
		}

		tessellator.setColorOpaque_F(brightness, brightness, brightness);
		IconCoordinate texture = this.getBlockTextureFromSideAndMetadata(Side.BOTTOM, renderBlocks.blockAccess.getBlockMetadata(x, y, z));
		if (renderBlocks.overrideBlockTexture != null) {
			texture = renderBlocks.overrideBlockTexture;
		}

		double uMin = texture.getIconUMin();
		double uMax = texture.getIconUMax();
		double vMin = texture.getIconVMin();
		double vMax = texture.getIconVMax();
		double xMin = (double)x + (double)0.5F - (double)0.25F;
		double xMax = (double)x + (double)0.5F + (double)0.25F;
		double zMin = (double)z + (double)0.5F - (double)0.5F;
		double zMax = (double)z + (double)0.5F + (double)0.5F;
		double yd = (double)((float)y - 0.0625F);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMax, uMax, vMin);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMax, uMax, vMin);
		xMin = (double)x + (double)0.5F - (double)0.5F;
		xMax = (double)x + (double)0.5F + (double)0.5F;
		zMin = (double)z + (double)0.5F - (double)0.25F;
		zMax = (double)z + (double)0.5F + (double)0.25F;
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMin, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMin, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMin, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMin, uMax, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMax, uMax, vMin);
		tessellator.addVertexWithUV(xMin, yd + (double)1.0F, zMax, uMin, vMin);
		tessellator.addVertexWithUV(xMin, yd + (double)0.0F, zMax, uMin, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)0.0F, zMax, uMax, vMax);
		tessellator.addVertexWithUV(xMax, yd + (double)1.0F, zMax, uMax, vMin);
		return true;
	}

	public boolean shouldItemRender3d() {
		return false;
	}

	public IconCoordinate getBlockTextureFromSideAndMetadata(Side side, int data) {
		return this.growthStageTextures[MathHelper.clamp(data, 0, 7)];
	}
}
