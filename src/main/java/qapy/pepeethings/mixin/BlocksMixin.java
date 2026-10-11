package qapy.pepeethings.mixin;

import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Materials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import qapy.pepeethings.ModBlocks;

@Mixin(Blocks.class)
public class BlocksMixin {
	@ModifyArg(
		method = "<clinit>",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/core/block/Blocks;register(Ljava/lang/String;Ljava/lang/String;ILnet/minecraft/core/block/BlockLogicSupplier;)Lnet/minecraft/core/block/Block;",
			ordinal = 10
		)
	)
	private static <T extends BlockLogic> BlockLogicSupplier<T> modifyBasaltSupplier(
		BlockLogicSupplier<T> original
	) {
		return b -> (T) new BlockLogicCobble(
			b,
			Materials.BASALT,
			() -> ModBlocks.GRAVEL_BASALT
		);
	}

	@ModifyArg(
		method = "<clinit>",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/core/block/Blocks;register(Ljava/lang/String;Ljava/lang/String;ILnet/minecraft/core/block/BlockLogicSupplier;)Lnet/minecraft/core/block/Block;",
			ordinal = 11
		)
	)
	private static <T extends BlockLogic> BlockLogicSupplier<T> modifyLimestoneSupplier(
		BlockLogicSupplier<T> original
	) {
		return b -> (T) new BlockLogicCobble(
			b,
			Materials.BASALT,
			() -> ModBlocks.GRAVEL_LIMESTONE
		);
	}

	@ModifyArg(
		method = "<clinit>",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/core/block/Blocks;register(Ljava/lang/String;Ljava/lang/String;ILnet/minecraft/core/block/BlockLogicSupplier;)Lnet/minecraft/core/block/Block;",
			ordinal = 12
		)
	)
	private static <T extends BlockLogic> BlockLogicSupplier<T> modifyGraniteSupplier(
		BlockLogicSupplier<T> original
	) {
		return b -> (T) new BlockLogicCobble(
			b,
			Materials.BASALT,
			() -> ModBlocks.GRAVEL_GRANITE
		);
	}

	@ModifyArg(
		method = "<clinit>",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/core/block/Blocks;register(Ljava/lang/String;Ljava/lang/String;ILnet/minecraft/core/block/BlockLogicSupplier;)Lnet/minecraft/core/block/Block;",
			ordinal = 13
		)
	)
	private static <T extends BlockLogic> BlockLogicSupplier<T> modifyPermafrostSupplier(
		BlockLogicSupplier<T> original
	) {
		return b -> (T) new BlockLogicCobble(
			b,
			Materials.BASALT,
			() -> ModBlocks.GRAVEL_PERMAFROST
		);
	}
}
