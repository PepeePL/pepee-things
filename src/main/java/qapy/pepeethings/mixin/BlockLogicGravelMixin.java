package qapy.pepeethings.mixin;

import net.minecraft.core.block.BlockLogicGravel;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import qapy.pepeethings.ModBlocks;

@Mixin(BlockLogicGravel.class)
public class BlockLogicGravelMixin {
	/**
	 * @author Pepee
	 * @reason Custom drop for gravel
	 */
	@Overwrite
	public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		ItemStack[] var10000;
		switch (dropCause) {
			case PISTON_CRUSH:
				var10000 = new ItemStack[]{new ItemStack(ModBlocks.SAND_ROCKY)};
				break;
			case PICK_BLOCK:
			case SILK_TOUCH:
				var10000 = new ItemStack[]{new ItemStack((BlockLogicGravel) (Object)this)};
				break;
			default:
				var10000 = world.rand.nextInt(10) == 0 ? new ItemStack[]{new ItemStack(Items.FLINT)} : new ItemStack[]{new ItemStack((BlockLogicGravel) (Object)this)};
		}

		return var10000;
	}
}
