package qapy.pepeethings.mixin.decorate;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.ModBlocks;
import qapy.pepeethings.WorldFeatureClayWhite;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class)
public class WhiteClayOverworldMixin {
	@Shadow @Final
	private World world;

	@Inject(
		method = "decorate",
		at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 33)
	)
	private void addWhiteClay(
		Chunk chunk, CallbackInfo ci, @Local(name = "rand") Random rand, @Local(name = "x") int x, @Local(name = "z") int z, @Local(name = "minY") int minY, @Local(name = "rangeY") int rangeY, @Local(name = "oreHeightModifier") float oreHeightModifier) {

		if(rand.nextInt(100) > 1) return;
		for (int i = 0; (float) i < 3.0F * oreHeightModifier; ++i) {
			int xf = x + rand.nextInt(16);
			int yf = minY + rand.nextInt(rangeY);
			int zf = z + rand.nextInt(16);

			new WorldFeatureClayWhite(
				64,
				ModBlocks.BLOCK_CLAY_WHITE,
				Blocks.SAND
			).place(this.world, rand, xf, yf, zf);
		}

	}
}
