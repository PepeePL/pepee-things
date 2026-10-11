package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGenericStairs;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.models.block.StaticBlockModel;

@Environment(EnvType.CLIENT)
public class BlockModelGenericStairsConcretePainted<T extends BlockLogic> extends BlockModelGenericStairs<T> {
	public final @NotNull StaticBlockModel[] models = new StaticBlockModel[16];

	public BlockModelGenericStairsConcretePainted(@NotNull Block<T> block) {
		super(block, BlockModelDispatcher.loadDataModel("pepeethings:block/stairs/concrete/" + DyeColor.WHITE.colorID));

		for(DyeColor color : DyeColor.blockOrderedColors()) {
			this.models[color.blockMeta] = BlockModelDispatcher.loadDataModel("pepeethings:block/stairs/concrete/" + color.colorID).asModel();
		}

	}

	public @NotNull StaticBlockModel getModelFromData(int data) {
		return this.models[data >> 4 & 15];
	}
}
