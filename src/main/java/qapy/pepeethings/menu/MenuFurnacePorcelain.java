package qapy.pepeethings.menu;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.crafting.ContainerListener;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuAbstract;
import net.minecraft.core.player.inventory.slot.Slot;
import net.minecraft.core.player.inventory.slot.SlotFurnace;
import org.jetbrains.annotations.NotNull;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;

public class MenuFurnacePorcelain extends MenuAbstract {
	public static final int ID_CURRENT_COOK_TIME = 0;
	public static final int ID_CURRENT_BURN_TIME = 1;
	public static final int ID_MAX_COOK_TIME = 2;
	public static final int ID_MAX_BURN_TIME = 3;
	private static final int NUM_INGREDIENT_SLOTS = 1;
	private static final int NUM_FUEL_SLOTS = 1;
	private static final int NUM_RESULT_SLOTS = 1;
	private static final int INGREDIENT_SLOTS_START = 0;
	private static final int FUEL_SLOTS_START = 1;
	private static final int RESULT_SLOTS_START = 2;
	private static final int INVENTORY_SLOTS_START = 3;
	private static final int HOTBAR_SLOTS_START = 30;
	public TileEntityFurnacePorcelain furnace;
	private float currentCookTime = 0;
	private float currentBurnTime = 0;
	private float speed = 0.1F;
	private int itemBurnTime = 0;
	private int itemCookTime = 0;

	public MenuFurnacePorcelain(ContainerInventory inventory, TileEntityFurnacePorcelain tileEntity) {
		this.furnace = tileEntity;
		this.addSlot(new Slot(tileEntity, 0, 56, 17));
		this.addSlot(new Slot(tileEntity, 1, 56, 53));
		this.addSlot(new SlotFurnace(inventory.player, tileEntity, 2, 116, 35));

		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 9; ++x) {
				this.addSlot(new Slot(inventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}

		for(int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(inventory, i, 8 + i * 18, 142));
		}

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

	@Override
	public IntList getMoveSlots(@NotNull InventoryAction action, @NotNull Slot slot, int target, Player player) {
		if (slot.index >= 0 && slot.index < 1) {
			return this.getSlots(0, 1, false);
		} else if (slot.index >= 1 && slot.index < 2) {
			return this.getSlots(1, 1, false);
		} else if (slot.index >= 2 && slot.index < 3) {
			return this.getSlots(2, 1, false);
		} else {
			if (action == InventoryAction.MOVE_ALL) {
				if (slot.index >= 3 && slot.index < 30) {
					return this.getSlots(3, 27, false);
				}

				if (slot.index >= 30 && slot.index < 39) {
					return this.getSlots(30, 9, false);
				}
			}

			return slot.index >= 3 && slot.index < 39 ? this.getSlots(3, 36, false) : null;
		}
	}

	@Override
	public IntList getTargetSlots(@NotNull InventoryAction action, @NotNull Slot slot, int target, Player player) {
		if (slot.index >= 3 && slot.index <= 39) {
			if (action != InventoryAction.MOVE_ALL) {
				if (target == 1) {
					return this.getSlots(0, 1, false);
				}

				if (target == 2) {
					return this.getSlots(1, 1, false);
				}
			}

			if (slot.index >= 3 && slot.index < 30) {
				return this.getSlots(30, 9, false);
			}

			if (slot.index >= 30 && slot.index < 39) {
				return this.getSlots(3, 27, false);
			}
		}

		if (slot.index >= 0 && slot.index < 3) {
			return slot.index == 2 ? this.getSlots(3, 36, true) : this.getSlots(3, 36, false);
		} else {
			return null;
		}
	}
}
