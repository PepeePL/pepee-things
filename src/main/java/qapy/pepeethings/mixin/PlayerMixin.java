package qapy.pepeethings.mixin;

import net.minecraft.core.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import qapy.pepeethings.util.IPlayer;

@Mixin(Player.class)
public class PlayerMixin implements IPlayer {
	@Override
	public void displayFurnacePorcelainScreen(TileEntityFurnacePorcelain furnacePorcelain) {}
}
