package qapy.pepeethings.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.core.item.tool.ItemToolPickaxe.miningLevels;

public class ItemToolHammer extends ItemTool {
	public final Tool tool;
	public ItemToolHammer(String name, String namespaceId, int id, Tool tool, ToolMaterial toolMaterial, Tag<Block<?>> tagEffectiveAgainst) {
		super(name, namespaceId, id, 2, toolMaterial, tagEffectiveAgainst);
		this.tool = tool;
		this.material = (new ToolMaterial())
			.setDurability(getMaterial().getDurability())
			.setEfficiency(toolMaterial.getEfficiency(false) * .2f, toolMaterial.getEfficiency(true) * .2f)
			.setMiningLevel(getMaterial().getMiningLevel())
			.setSilkTouch(isSilkTouch());
	}

	@Override
	public boolean canHarvestBlock(@NotNull ItemStack itemStack, @NotNull Mob mob, @NotNull Block<?> block) {
		int miningLevel = miningLevels.getOrDefault(block, -1);
		if (miningLevel != -1) {
			return this.material.getMiningLevel() >= miningLevel;
		} else {
			if (this.tool == Tool.SHOVEL) {
				return block.hasTag(BlockTags.MINEABLE_BY_SHOVEL);
			}
			return block.hasTag(BlockTags.MINEABLE_BY_PICKAXE);
		}
	}

	@Override
	public boolean onBlockDestroyed(@NotNull ItemStack itemStack, @NotNull World world, @NotNull Mob mob, @NotNull Block<?> removedBlock, @NotNull TilePosc blockPos, @NotNull Side side) {
		Player player = (Player) mob;
			if ((removedBlock.getHardness() > 0.0F || this.isSilkTouch())) {
				itemStack.damageItem(4, player);
				if (player.isSneaking()) return true;
				if (side == Side.NORTH || side == Side.SOUTH) {
					for (int dx = -1; dx <= 1; dx++) {
						for (int dy = -1; dy <= 1; dy++) {
							if (dx == 0 && dy == 0) continue;
							int targetX = blockPos.x() + dx;
							int targetY = blockPos.y() + dy;
							int targetZ = blockPos.z();
							mine(itemStack, world, mob, player, targetX, targetY, targetZ);
						}
					}
				}
				if (side == Side.WEST || side == Side.EAST) {
					for (int dz = -1; dz <= 1; dz++) {
						for (int dy = -1; dy <= 1; dy++) {
							if (dz == 0 && dy == 0) continue;
							int targetZ = blockPos.z() + dz;
							int targetY = blockPos.y() + dy;
							int targetX = blockPos.x();
							mine(itemStack, world, mob, player, targetX, targetY, targetZ);
						}
					}
				}
				if (side == Side.BOTTOM || side == Side.TOP) {
					for (int dx = -1; dx <= 1; dx++) {
						for (int dz = -1; dz <= 1; dz++) {
							if (dx == 0 && dz == 0) continue;
							int targetX = blockPos.x() + dx;
							int targetZ = blockPos.z() + dz;
							int targetY = blockPos.y();
							mine(itemStack, world, mob, player, targetX, targetY, targetZ);
						}
					}
				}
			}
		return true;
	}

	private void mine(@NotNull ItemStack itemStack, @NotNull World world, @NotNull Mob mob, Player player, int targetX, int targetY, int targetZ) {
		TilePosc targetPos = new TilePos(targetX, targetY, targetZ);
		Block<?> targetBlock = world.getBlockType(targetPos);
		if (canHarvestBlock(itemStack, mob, targetBlock)) {
			if (player.getGamemode().hasItemDrops())
				targetBlock.onHarvest(world, player, targetPos, 0, null);
			world.setBlockTypeNotify(targetPos, Blocks.AIR);
		}
	}
	public enum Tool{
		SHOVEL, PICKAXE
	}
}
