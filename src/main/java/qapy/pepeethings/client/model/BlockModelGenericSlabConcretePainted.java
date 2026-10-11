package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.models.block.StaticBlockModel;

@Environment(EnvType.CLIENT)
public class BlockModelGenericSlabConcretePainted<T extends BlockLogic> extends BlockModelGeneric<T> {
	public final @NotNull StaticBlockModel[] upper = new StaticBlockModel[16];
	public final @NotNull StaticBlockModel[] lower = new StaticBlockModel[16];
	public final @NotNull StaticBlockModel[] full = new StaticBlockModel[16];

	public BlockModelGenericSlabConcretePainted(@NotNull Block<T> block) {
		super(block, BlockModelDispatcher.loadDataModel("pepeethings:block/slab/concrete/white/lower"));

		for(DyeColor color : DyeColor.blockOrderedColors()) {
			this.upper[color.blockMeta] = BlockModelDispatcher.loadDataModel("pepeethings:block/slab/concrete/" + color.colorID + "/upper").asModel();
			this.lower[color.blockMeta] = BlockModelDispatcher.loadDataModel("pepeethings:block/slab/concrete/" + color.colorID + "/lower").asModel();
			this.full[color.blockMeta] = BlockModelDispatcher.loadDataModel("pepeethings:block/slab/concrete/" + color.colorID + "/full").asModel();
		}

	}

	public @NotNull StaticBlockModel getModelFromData(int data) {
		int color = data >> 4 & 15;
		StaticBlockModel var10000;
		switch (data & 3) {
			case 1 -> var10000 = this.full[color];
			case 2 -> var10000 = this.upper[color];
			default -> var10000 = this.lower[color];
		}

		return var10000;
	}
}
