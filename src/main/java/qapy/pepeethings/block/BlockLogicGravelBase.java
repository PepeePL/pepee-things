package qapy.pepeethings.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicFallingBlock;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicGravelBase extends BlockLogicFallingBlock {
	Block<?> pistonCrushedBlock;
	public BlockLogicGravelBase(@NotNull Block<?> block, Block<?> pistonCrushedBlock) {
		super(block, Materials.SAND);
		this.pistonCrushedBlock = pistonCrushedBlock;
	}

	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		return switch (dropCause) {
			case PISTON_CRUSH -> new ItemStack[]{new ItemStack(pistonCrushedBlock)};
			case PICK_BLOCK, SILK_TOUCH -> new ItemStack[]{new ItemStack(this)};
			default ->
				world.rand.nextInt(10) == 0 ? new ItemStack[]{new ItemStack(Items.FLINT)} : new ItemStack[]{new ItemStack(this)};
		};
	}
}
