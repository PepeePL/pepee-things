package qapy.pepeethings.block.entity;

import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.ListTag;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryFurnace;
import net.minecraft.core.item.ItemBucket;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import qapy.pepeethings.ModBlocks;
import qapy.pepeethings.block.BlockLogicFurnacePorcelain;

import java.util.List;

public class TileEntityFurnacePorcelain extends TileEntityFurnace {
	public float speed = 0.1F;
	public float currentBurnTime;
	public float currentCookTime;
	private final int maxSpeed = 16;
	private final float acceleration = 0.002F;

	public TileEntityFurnacePorcelain() {}

	public @NotNull String getNameTranslationKey() {
		return "container.furnace.porcelain.name";
	}

	public void readAdditionalData(@NotNull CompoundTag compoundTag) {
		ListTag nbttaglist = compoundTag.getList("Items");
		this.furnaceItemStacks = new ItemStack[this.getContainerSize()];

		for(int i = 0; i < nbttaglist.tagCount(); ++i) {
			CompoundTag nbttagcompound1 = (CompoundTag)nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound1.getByte("Slot");
			if (byte0 >= 0 && byte0 < this.furnaceItemStacks.length) {
				this.furnaceItemStacks[byte0] = ItemStack.readItemStackFromNbt(nbttagcompound1);
			}
		}

		this.currentBurnTime = compoundTag.getFloat("BurnTime");
		this.currentCookTime = compoundTag.getFloat("CookTime");
		this.maxBurnTime = compoundTag.getShort("MaxBurnTime");
		this.speed = compoundTag.getFloat("Speed");
	}

	public void writeAdditionalData(@NotNull CompoundTag compoundTag) {
		compoundTag.putFloat("BurnTime", this.currentBurnTime);
		compoundTag.putFloat("CookTime", this.currentCookTime);
		compoundTag.putFloat("Speed", this.speed);
		compoundTag.putShort("MaxBurnTime", (short)this.maxBurnTime);
		ListTag nbttaglist = new ListTag();

		for(int i = 0; i < this.furnaceItemStacks.length; ++i) {
			if (this.furnaceItemStacks[i] != null) {
				CompoundTag nbttagcompound1 = new CompoundTag();
				nbttagcompound1.putByte("Slot", (byte)i);
				this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.addTag(nbttagcompound1);
			}
		}
		compoundTag.put("Items", nbttaglist);
	}

	@Override
	public boolean isBurning() {
		return this.currentBurnTime > 0;
	}

	public int getCookProgressScaled(int i) {
		return this.maxCookTime == 0 ? 0 : (int) (this.currentCookTime * i / this.maxCookTime);
	}

	public int getBurnTimeRemainingScaled(int i) {
		return this.maxBurnTime == 0 ? 0 : (int) (this.currentBurnTime * i / this.maxBurnTime);
	}

	public int getSpeedScaled(int i) {
		return (int) (this.speed * i / this.maxSpeed);
	}

	public void tick() {
		boolean isBurnTimeHigherThan0 = this.currentBurnTime > 0;
		boolean furnaceUpdated = false;
		if (this.currentBurnTime > 0) {
			this.currentBurnTime = this.currentBurnTime - (0.8f * this.speed);
		}
		if (this.worldObj == null || !this.worldObj.isClientSide) {
			if ((this.worldObj == null || this.worldObj.getBlockId(this.tilePos.x, this.tilePos.y, this.tilePos.z) == Blocks.FURNACE_STONE_IDLE.id()) && this.currentBurnTime == 0 && this.furnaceItemStacks[0] == null && this.furnaceItemStacks[1] != null && this.furnaceItemStacks[1].itemID == Blocks.COBBLE_NETHERRACK.id()) {
				--this.furnaceItemStacks[1].stackSize;
				if (this.furnaceItemStacks[1].stackSize <= 0) {
					this.furnaceItemStacks[1] = null;
				}

				this.updateFurnace(true);
				furnaceUpdated = true;
			}
			if (this.currentBurnTime <= 0 && this.furnaceItemStacks[1] != null && this.canSmelt()) {
				this.maxBurnTime = (int) (this.currentBurnTime = this.getBurnTimeFromItem(this.furnaceItemStacks[1]));
				if (this.currentBurnTime > 0) {
					furnaceUpdated = true;
					if (this.furnaceItemStacks[1] != null) {
						ItemStack fuelStack = this.furnaceItemStacks[1];
						if (fuelStack.getItem() instanceof ItemBucket && ItemBucket.STATE_LAVA.equals(ItemBucket.getState(fuelStack))) {
							ItemBucket.setCharges(fuelStack, ItemBucket.getCharges(fuelStack) - 1);
							if (ItemBucket.getCharges(fuelStack) <= 0) {
								ItemBucket.setState(fuelStack, ItemBucket.STATE_EMPTY);
							}
						} else {
							--fuelStack.stackSize;
							if (fuelStack.stackSize <= 0) {
								this.furnaceItemStacks[1] = null;
							}
						}
					}
				}
			}
			if (this.isBurning() && this.canSmelt()) {
				this.currentCookTime = this.currentCookTime + (1 * this.speed);
				if (this.speed < this.maxSpeed) {
					this.speed += acceleration;
				} else this.speed =this.maxSpeed;
				if (this.currentCookTime >= this.maxCookTime) {
					this.currentCookTime = 0;
					this.smeltItem();
					furnaceUpdated = true;
				}
			} else {
				if(this.speed > 0.1F){
					this.speed -= acceleration*10;
				}
				else this.speed =0.1F;
				this.currentCookTime = 0;
			}
			if (isBurnTimeHigherThan0 != this.currentBurnTime > 0) {
				furnaceUpdated = true;
				this.updateFurnace(false);
			}
		}
		if (furnaceUpdated) {
			this.setChanged();
		}
	}

	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			List<RecipeEntryFurnace> list = Registries.RECIPES.getAllFurnaceRecipes();
			ItemStack itemstack = null;

			for(RecipeEntryFurnace recipeEntryBase : list) {
				if (recipeEntryBase != null && recipeEntryBase.matches(this.furnaceItemStacks[0])) {
					itemstack = recipeEntryBase.getOutput();
				}
			}

			if (itemstack == null) {
				return false;
			} else if (this.furnaceItemStacks[2] == null) {
				return true;
			} else if (!this.furnaceItemStacks[2].isItemEqual(itemstack)) {
				return false;
			} else if (this.furnaceItemStacks[2].stackSize < this.getMaxStackSize() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) {
				return true;
			} else {
				return this.furnaceItemStacks[2].stackSize < itemstack.getMaxStackSize();
			}
		}
	}

	protected void updateFurnace(boolean forceLit) {
		if (this.worldObj != null) {
			BlockLogicFurnacePorcelain.updateFurnaceBlockState(this.worldObj, this.tilePos, forceLit | this.currentBurnTime > 0);
		} else if (this.carriedBlock != null) {
			this.carriedBlock.blockId = forceLit | this.currentBurnTime > 0 ? ModBlocks.PORCELAIN_FURNACE_ACTIVE.id() : ModBlocks.PORCELAIN_FURNACE_IDLE.id();
		}
	}

	private int getBurnTimeFromItem(ItemStack itemStack) {
		return itemStack == null ? 0 : LookupFuelFurnace.instance.getFuelYield(itemStack);
	}
}
