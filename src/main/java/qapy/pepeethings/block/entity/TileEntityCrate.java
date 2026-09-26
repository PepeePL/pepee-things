package qapy.pepeethings.block.entity;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.ICarriable;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import qapy.pepeethings.item.ModItemTags;


public class TileEntityCrate extends TileEntity implements ICarriable {
	private Item storedItem;
	private int storedCount;
	final int MAX_CAPACITY = 32;

	public boolean isEmpty() {
		return storedItem == null;
	}

	public boolean canInsert(Item item) {
		return (storedItem == null || storedItem == item) && item.hasTag(ModItemTags.PUTABLE_INTO_CRATE);
	}

	public boolean addItem(Item item) {
		if (!canInsert(item)) return false;
		if (storedCount >= MAX_CAPACITY) return false;
		if (storedItem == null) {
			storedItem = item; // bind crate to this item
		}
		storedCount++;
		return true;
	}
	public void dropItem(World world, int x, int y, int z) {
		if(!isEmpty()){
			EntityItem entityItem = new EntityItem(world, x + 0.5, y + 1, z + 0.5, new ItemStack(storedItem, 1));
			world.entityJoinedWorld(entityItem);
			storedCount--;
			if (storedCount <= 0) storedItem = null;
		}
	}

	public void dropContents(World world, int x, int y, int z) {
		super.dropContents(world, x, y, z);
		if(!isEmpty()){
			EntityItem entityItem = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(storedItem, storedCount));
			world.entityJoinedWorld(entityItem);
			storedItem = null;
			storedCount = 0;
		}
	}

	@Override
	public void writeAdditionalData(@NotNull CompoundTag tag) {
		if (storedItem != null) {
			tag.putInt("item", storedItem.id);
		}
		tag.putInt("count", storedCount);
	}

	@Override
	public void readAdditionalData(@NotNull CompoundTag tag) {
		if (tag.containsKey("item")) {
			storedItem = Item.getItem(tag.getInteger("item"));
		} else {
			storedItem = null;
		}
		storedCount = tag.getInteger("count");
	}

	public Item getStoredItem() {
		return storedItem;
	}

	public int getCount() {
		return storedCount;
	}

	public float getFillRatio() {
		return (float) storedCount / MAX_CAPACITY;
	}

}
