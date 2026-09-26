package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.models.block.StaticBlockModel;

@Environment(EnvType.CLIENT)
public class BlockModelGenericCrops<T extends BlockLogic> extends BlockModelGeneric<T> {

	public final StaticBlockModel[] models = new StaticBlockModel[8];

	public BlockModelGenericCrops(@NotNull Block<T> block, String cropName) {
		super(block, BlockModelDispatcher.loadDataModel(String.format("pepeethings:block/%s/stage0", cropName)));

		for(int i = 0; i < this.models.length; ++i) {
			this.models[i] = BlockModelDispatcher.loadDataModel(String.format("pepeethings:block/%s/stage" + i, cropName)).asModel();
		}

	}

	public @NotNull StaticBlockModel getModelFromData(int data) {
		return this.models[data % this.models.length];
	}
}
