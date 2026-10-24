package qapy.pepeethings.client.gui;

import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import qapy.pepeethings.menu.MenuFurnacePorcelain;

public class ScreenFurnacePorcelain extends ScreenContainerAbstract {
	private final TileEntityFurnacePorcelain furnaceInventory;

	public ScreenFurnacePorcelain(ContainerInventory inventory, TileEntityFurnacePorcelain tileEntityFurnacePorcelain) {
		super(new MenuFurnacePorcelain(inventory, tileEntityFurnacePorcelain));
		this.furnaceInventory = tileEntityFurnacePorcelain;
	}

	protected void drawGuiContainerForegroundLayer() {
		I18n i18n = I18n.getInstance();
		this.drawStringNoShadow(this.fontRenderer, i18n.translateKey("gui.furnace.label.furnace.porcelain"), 48, 6, 4210752);
		this.drawStringNoShadow(this.fontRenderer, i18n.translateKey("gui.furnace.label.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float partialTick) {
		this.mc.textureManager.loadTexture("/assets/pepeethings/textures/gui/container/furnace_porcelain.png").bind();
		GLRenderer.setColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		if (this.furnaceInventory.isBurning()) {
			int fireHeight = this.furnaceInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(x + 56, y + 36 + 12 - fireHeight, 176, 12 - fireHeight, 14, fireHeight + 2);
			int arrowWidth = this.furnaceInventory.getCookProgressScaled(24);
			this.drawTexturedModalRect(x + 79, y + 34, 176, 14, arrowWidth + 1, 16);
		}
		int speedHeight = this.furnaceInventory.getSpeedScaled(27);
		this.drawTexturedModalRect(x + 140, y + 31 + 25 - speedHeight, 176, 31 + 27 - speedHeight, 27, speedHeight);
	}
}
