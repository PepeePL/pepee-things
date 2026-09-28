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
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;
import qapy.pepeethings.block.ModBlockTags;

public class ItemSickle extends ItemTool {
	public ItemSickle(String name, String namespaceId, int id, int damageDealt, ToolMaterial toolMaterial) {
		super(name, namespaceId, id, damageDealt, toolMaterial, BlockTags.MINEABLE_BY_HOE);
	}

	@Override
	public boolean onBlockDestroyed(@NotNull ItemStack itemStack, @NotNull World world, @NotNull Mob mob, @NotNull Block<?> removedBlock, @NotNull TilePosc blockPos, @NotNull Side side) {
		Player player = (Player) mob;
		if (removedBlock.hasTag(ModBlockTags.SICKABLE_BLOCKS) && !player.isSneaking()){
			itemStack.damageItem(1, player);
			int radius = this.getMaterial().getMiningLevel() + 1;
			int x = blockPos.x();
			int y = blockPos.y();
			int z = blockPos.z();
			AABBd area = new AABBd(x - radius, y - 1, z - radius, x + radius, y + 1, z + radius);
			for (int bx = (int) area.minX; bx <= (int) area.maxX; bx++) {
				for (int by = (int) area.minY; by <= (int) area.maxY; by++) {
					for (int bz = (int) area.minZ; bz <= (int) area.maxZ; bz++) {
						TilePosc targetPos = new TilePos(bx, by, bz);
						Block<?> targetBlock = world.getBlockType(targetPos);
						if (targetBlock.hasTag(ModBlockTags.SICKABLE_BLOCKS)) {
							boolean isLeaves = removedBlock.hasTag(ModBlockTags.LEAVES);
							if((isLeaves && !targetBlock.hasTag(ModBlockTags.LEAVES)) || (!isLeaves && targetBlock.hasTag(ModBlockTags.LEAVES))) continue;
							int targetMeta = world.getBlockData(targetPos);
							if(targetBlock.hasTag(ModBlockTags.CROPS) && targetMeta != 7) continue;
							if (itemStack.stackSize <= 0) {
								player.destroyCurrentEquippedItem();
								return false;
							}
							itemStack.damageItem(3, player);
							if (player.getGamemode().hasItemDrops()){
								if((Block.hasLogicClass(targetBlock, BlockLogicFlowerStackable.class)) && targetMeta > 0){
									targetBlock.dropWithCause(world, EnumDropCause.PROPER_TOOL, targetPos, targetMeta, null, player);
								}else{
									targetBlock.onHarvest(world, player, targetPos, targetMeta, null);
								}
							}
							world.setBlockTypeNotify(targetPos, Blocks.AIR);
						}
					}
				}
			}
		}
		return true;
	}
}
