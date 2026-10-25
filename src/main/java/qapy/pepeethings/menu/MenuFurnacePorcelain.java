package qapy.pepeethings.menu;

import net.minecraft.core.crafting.ContainerListener;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuFurnace;
import org.jetbrains.annotations.NotNull;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;

public class MenuFurnacePorcelain extends MenuFurnace {
	public TileEntityFurnacePorcelain furnace;
	private float currentCookTime = 0;
	private float currentBurnTime = 0;
	private float speed = 0.1F;
	private int itemBurnTime = 0;
	private int itemCookTime = 0;

	public MenuFurnacePorcelain(ContainerInventory inventory, TileEntityFurnacePorcelain tileEntity) {
		super(inventory, tileEntity);
		this.furnace = tileEntity;
	}

	public void broadcastChanges() {
		super.broadcastChanges();

		for(ContainerListener crafter : this.containerListeners) {
			if (this.currentCookTime != this.furnace.currentCookTime) {
				crafter.updateCraftingInventoryInfo(this, 0, (int) this.furnace.currentCookTime);
			}

			if (this.currentBurnTime != this.furnace.currentBurnTime) {
				crafter.updateCraftingInventoryInfo(this, 1, (int) this.furnace.currentBurnTime);
			}

			if (this.itemCookTime != this.furnace.maxCookTime) {
				crafter.updateCraftingInventoryInfo(this, 2, this.furnace.maxCookTime);
			}

			if (this.itemBurnTime != this.furnace.maxBurnTime) {
				crafter.updateCraftingInventoryInfo(this, 3, this.furnace.maxBurnTime);
			}

			if (this.speed != this.furnace.speed) {
				crafter.updateCraftingInventoryInfo(this, 4, (int) this.furnace.speed);
			}
		}
		this.currentCookTime = this.furnace.currentCookTime;
		this.currentBurnTime = this.furnace.currentBurnTime;
		this.itemCookTime = this.furnace.maxCookTime;
		this.itemBurnTime = this.furnace.maxBurnTime;
		this.speed = this.furnace.speed;
	}

	public void setData(int id, int value) {
		switch (id) {
			case 0 -> this.furnace.currentCookTime = value;
			case 1 -> this.furnace.currentBurnTime = value;
			case 2 -> this.furnace.maxCookTime = value;
			case 3 -> this.furnace.maxBurnTime = value;
			case 4 -> this.furnace.speed = value;
		}
	}

	public boolean stillValid(@NotNull Player player) {
		return this.furnace.stillValid(player);
	}
}
