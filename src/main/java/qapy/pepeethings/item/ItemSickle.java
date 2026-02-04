package qapy.pepeethings.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFlowerStackable;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import qapy.pepeethings.block.ModBlockTags;

public class ItemSickle extends ItemTool {
	public ItemSickle(String name, String namespaceId, int id, int damageDealt, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, damageDealt, toolMaterial, BlockTags.MINEABLE_BY_HOE);
	}

	@Override
	public boolean onBlockDestroyed(World world, ItemStack itemstack, int i, int x, int y, int z, Side side, Mob mob) {
		Block<?> block = Blocks.blocksList[i];
		Player player = (Player) mob;
		if (block != null && block.hasTag(ModBlockTags.SICKABLE_BLOCKS) && !player.isSneaking()){
			itemstack.damageItem(1, player);
			int radius = this.getMaterial().getMiningLevel() + 1;
			AABB area = AABB.getPermanentBB(x - radius, y - 1, z - radius, x + radius, y + 1, z + radius);
			for (int bx = (int) area.minX; bx <= (int) area.maxX; bx++) {
				for (int by = (int) area.minY; by <= (int) area.maxY; by++) {
					for (int bz = (int) area.minZ; bz <= (int) area.maxZ; bz++) {
						int targetBlockID = world.getBlockId(bx, by, bz);
						Block<?> targetBlock = Blocks.blocksList[targetBlockID];
						if (targetBlock != null && targetBlock.hasTag(ModBlockTags.SICKABLE_BLOCKS)) {
							boolean isLeaves = block.hasTag(ModBlockTags.LEAVES);
							if((isLeaves && !targetBlock.hasTag(ModBlockTags.LEAVES)) || (!isLeaves && targetBlock.hasTag(ModBlockTags.LEAVES))) continue;
							int targetMeta = world.getBlockMetadata(bx, by, bz);
							if(targetBlock == Blocks.CROPS_WHEAT && targetMeta != 7) continue;
							if (itemstack.stackSize <= 0) {
								player.destroyCurrentEquippedItem();
								return false;
							}
							itemstack.damageItem(3, player);
							if (player.getGamemode().dropBlockOnBreak()){
								if((Block.hasLogicClass(targetBlock, BlockLogicFlowerStackable.class)) && targetMeta > 0){
									targetBlock.dropBlockWithCause(world, EnumDropCause.PROPER_TOOL, bx, by, bz, targetMeta, null, player);
								}else{
									targetBlock.harvestBlock(world, player, bx, by, bz, targetMeta, null);
								}
							}
							world.setBlockWithNotify(bx, by, bz, 0);
						}
					}
				}
			}
		}
		return true;
	}
}
