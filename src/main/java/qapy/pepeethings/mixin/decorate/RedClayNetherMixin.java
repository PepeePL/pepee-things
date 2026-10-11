package qapy.pepeethings.mixin.decorate;

import net.minecraft.core.world.generate.chunk.*;
import net.minecraft.core.world.generate.chunk.perlin.nether.ChunkDecoratorNether;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.ModBlocks;

@Mixin(ChunkDecoratorNether.class)
public class RedClayNetherMixin {
	@Inject(method = "registerDecorations", at = @At("TAIL"))
	public void registerDecorations(CallbackInfo ci){
		((ChunkFeatureDecorator) (Object) this).register("pepeethings:decoration/nether/default/red_clay_ore",
			(new ChunkDecorationBuilder(new WorldFeatureOre(ModBlocks.BLOCK_CLAY_RED.id(), 16)))
				.withPositionSelector(PositionSelectors.HeightRangeUniform)
				.withPlacementMethod(new PlacementMethod.TriesPerChunk(24)));
	}
}
