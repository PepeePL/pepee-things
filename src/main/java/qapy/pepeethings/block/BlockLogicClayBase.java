package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicClayBase extends BlockLogic {
	private final Item dropItem;
	public BlockLogicClayBase(@NotNull Block<?> block, Item dropItem) {
		super(block, Materials.CLAY);
		this.dropItem = dropItem;
	}
	@Override
	public @NotNull ItemStack @Nullable [] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, @NotNull TilePosc tilePos, int data, @Nullable TileEntity tileEntity) {
		return switch (dropCause) {
			case SILK_TOUCH, PICK_BLOCK -> new ItemStack[]{new ItemStack(this)};
			default -> new ItemStack[]{new ItemStack(this.dropItem, 4)};
		};
	}
}
