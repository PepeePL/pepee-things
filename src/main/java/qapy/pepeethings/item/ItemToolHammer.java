package qapy.pepeethings.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;

public class ItemToolHammer extends ItemTool {
	public ItemToolHammer(String name, String namespaceId, int id, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, 2, toolMaterial, BlockTags.MINEABLE_BY_PICKAXE);
		this.material = (new ToolMaterial())
			.setDurability(getMaterial().getDurability())
			.setEfficiency(toolMaterial.getEfficiency(false) * .8f, toolMaterial.getEfficiency(true) * .8f)
			.setMiningLevel(getMaterial().getMiningLevel())
			.setSilkTouch(isSilkTouch());
	}

	@Override
	public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
		Integer miningLevel = miningLevels.get(block);
		if (miningLevel != null) {
			return this.material.getMiningLevel() >= miningLevel;
		} else {
			return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE);
		}
	}

	@Override
	public boolean onBlockDestroyed(World world, ItemStack itemstack, int i, int x, int y, int z, Side side, Mob mob) {
		Block<?> block = Blocks.blocksList[i];
		Player player = (Player) mob;
			if (block != null && (block.getHardness() > 0.0F || this.isSilkTouch()) && !player.isSneaking()) {
				itemstack.damageItem(2, player);
				if (side == Side.NORTH || side == Side.SOUTH) {
					for (int dx = -1; dx <= 1; dx++) {
						for (int dy = -1; dy <= 1; dy++) {
							if (dx == 0 && dy == 0) continue;
							int targetX = x + dx;
							int targetY = y + dy;
							int targetZ = z;
							int targetBlockID = world.getBlockId(targetX, targetY, targetZ);
							Block<?> targetBlock = Blocks.blocksList[targetBlockID];
							if (targetBlock != null && targetBlock.hasTag(BlockTags.MINEABLE_BY_PICKAXE) && canHarvestBlock(mob, itemstack, targetBlock)) {
								if (player.getGamemode().dropBlockOnBreak())
									targetBlock.harvestBlock(world, player, targetX, targetY, targetZ, 0, null);
								world.setBlockWithNotify(targetX, targetY, targetZ, 0);
							}
						}
					}
				}
				if (side == Side.WEST || side == Side.EAST) {
					for (int dz = -1; dz <= 1; dz++) {
						for (int dy = -1; dy <= 1; dy++) {
							if (dz == 0 && dy == 0) continue;
							int targetZ = z + dz;
							int targetY = y + dy;
							int targetX = x;
							int targetBlockID = world.getBlockId(targetX, targetY, targetZ);
							Block<?> targetBlock = Blocks.blocksList[targetBlockID];
							if (targetBlock != null && block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) && canHarvestBlock(mob, itemstack, targetBlock)) {
								if (player.getGamemode().dropBlockOnBreak())
									targetBlock.harvestBlock(world, player, targetX, targetY, targetZ, 0, null);
								world.setBlockWithNotify(targetX, targetY, targetZ, 0);
							}
						}
					}
				}
				if (side == Side.BOTTOM || side == Side.TOP) {
					for (int dx = -1; dx <= 1; dx++) {
						for (int dz = -1; dz <= 1; dz++) {
							if (dx == 0 && dz == 0) continue;
							int targetX = x + dx;
							int targetZ = z + dz;
							int targetY = y;
							int targetBlockID = world.getBlockId(targetX, targetY, targetZ);
							Block<?> targetBlock = Blocks.blocksList[targetBlockID];
							if (targetBlock != null && block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) && canHarvestBlock(mob, itemstack, targetBlock)) {
								if (player.getGamemode().dropBlockOnBreak())
									targetBlock.harvestBlock(world, player, targetX, targetY, targetZ, 0, null);
								world.setBlockWithNotify(targetX, targetY, targetZ, 0);
							}
						}
					}
				}
			}
		return true;
	}
}
