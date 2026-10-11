package qapy.pepeethings.mixin.decorate;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.block.BlockLogicOreIron;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.overworld.ChunkDecoratorOverworld;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import net.minecraft.core.world.pos.TilePos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.ModBlocks;

import java.util.Random;

@Mixin(value = ChunkDecoratorOverworld.class)
public class BlueClayOverworldMixin {
	@Shadow
	@Final
	private World world;
	@Inject(
		method = "decorate",
		at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 33)
	)
	private void addBlueClay(Chunk chunk, CallbackInfo ci, @Local(name = "rand") Random rand, @Local(name = "x") int x, @Local(name = "z") int z, @Local(name = "minY") int minY, @Local(name = "rangeY") int rangeY, @Local(name = "oreHeightModifier") float oreHeightModifier) {
		for(int j3 = 0; (float)j3 < 4.0F * oreHeightModifier; ++j3) {
			if (rand.nextInt(24) > 1) continue;
			int k6 = x + rand.nextInt(16);
			int l9 = minY + rand.nextInt(rangeY / 4);
			int k12 = z + rand.nextInt(16);
			TilePos queryPos = new TilePos(k6, l9, k12);
			(new WorldFeatureOre(ModBlocks.BLOCK_CLAY_BLUE.id(), 10)).place(this.world, rand, queryPos);
		}

	}
}
