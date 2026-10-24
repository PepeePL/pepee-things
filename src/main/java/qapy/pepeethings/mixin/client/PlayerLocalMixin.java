package qapy.pepeethings.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.PlayerLocal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import qapy.pepeethings.client.gui.ScreenFurnacePorcelain;
import qapy.pepeethings.util.IPlayer;

@Mixin(PlayerLocal.class)
public class PlayerLocalMixin implements IPlayer {

	@Shadow
	protected Minecraft mc;
	@Unique
	private final PlayerLocal thisPlayer = (PlayerLocal)(Object)this;

	@Override
	public void displayFurnacePorcelainScreen(TileEntityFurnacePorcelain furnacePorcelain) {
		this.mc.displayScreen(new ScreenFurnacePorcelain(thisPlayer.inventory, furnacePorcelain));

	}
}
