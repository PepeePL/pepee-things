package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import qapy.pepeethings.block.entity.TileEntityCrate;

public class BlockLogicCrate extends BlockLogic {
	private final Item CRATE_ITEM;

	public BlockLogicCrate(Block<?> block, Material material, Item crateItem) {
		super(block, material);
		this.CRATE_ITEM = crateItem;
		block.withEntity(TileEntityCrate::new);
	}

	public boolean onBlockRightClicked(World world, int x, int y, int z, Player entityplayer, Side side, double xPlaced, double yPlaced) {
		ItemStack heldItemStack = entityplayer.getHeldItem();
		TileEntityCrate te = (TileEntityCrate) world.getTileEntity(x, y, z);
		if (heldItemStack != null) {
			if (te.addItem(heldItemStack.getItem())) {
				if (entityplayer.getGamemode().consumeBlocks()) {
					entityplayer.getHeldItem().stackSize--;
				}
				world.playSoundEffect(entityplayer, SoundCategory.WORLD_SOUNDS, x, y, z, "minecraft:step.cloth", 1.0F, 0.5F);
				world.markBlockNeedsUpdate(x, y, z);
				return true;
			}
		}
		return false;
	}

	@Override
	public void onBlockLeftClicked(World world, int x, int y, int z, Player entityplayer, Side side, double xHit, double yHit) {
		if (!Item.hasTag(entityplayer.getCurrentEquippedItem(), ItemTags.PREVENT_LEFT_CLICK_INTERACTIONS)) {
			TileEntityCrate te = (TileEntityCrate) world.getTileEntity(x, y, z);
			te.dropItem(world, x, y, z);
		}
	}

	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(CRATE_ITEM)};
	}
}
