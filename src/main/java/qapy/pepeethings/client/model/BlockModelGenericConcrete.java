package qapy.pepeethings.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.data.block.BlockModelData;
import org.useless.dragonfly.models.block.StaticBlockModel;

@Environment(EnvType.CLIENT)
public class BlockModelGenericConcrete <T extends BlockLogic> extends BlockModelGeneric<T> {
	public final StaticBlockModel[] models = new StaticBlockModel[16];

	public BlockModelGenericConcrete(@NotNull Block<T> block, @NotNull StaticBlockModel staticModel) {
		super(block, staticModel);

		for(DyeColor c : DyeColor.blockOrderedColors()) {
			this.models[c.blockMeta] = BlockModelDispatcher.loadDataModel("pepeethings:block/concrete/" + c.colorID).asModel();
		}

	}

	public BlockModelGenericConcrete(@NotNull Block<T> block, @NotNull BlockModelData staticModel) {
		super(block, staticModel);

		for(DyeColor c : DyeColor.blockOrderedColors()) {
			this.models[c.blockMeta] = BlockModelDispatcher.loadDataModel("pepeethings:block/concrete/" + c.colorID).asModel();
		}

	}

	public @NotNull StaticBlockModel getModelFromData(int data) {
		return this.models[data & 15];
	}
}
