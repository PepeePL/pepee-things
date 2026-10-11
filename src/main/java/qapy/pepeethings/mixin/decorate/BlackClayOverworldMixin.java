package qapy.pepeethings.mixin.decorate;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.WorldFeatureClayBlack;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class)
public class BlackClayOverworldMixin {
	@Shadow
	@Final
	private World world;
	@Inject(
		method = "decorate",
		at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 33)
	)
	private void addBlackClay(
		Chunk chunk, CallbackInfo ci, @Local(name = "rand") Random rand, @Local(name = "x") int x, @Local(name = "z") int z, @Local(name = "minY") int minY, @Local(name = "rangeY") int rangeY, @Local(name = "oreHeightModifier") float oreHeightModifier) {
		int l5 = x + rand.nextInt(16);
		int l11 = z + rand.nextInt(16);
		int i9 = this.world.getHeightValue(l5, l11);
		if(rand.nextInt(1000) > 2) return;
		(new WorldFeatureClayBlack(3)).place(this.world, rand, l5, i9, l11);

	}
}
