package qapy.pepeethings.mixin.server;

import net.minecraft.core.net.packet.PacketContainerOpen;
import net.minecraft.server.entity.player.PlayerServer;
import net.minecraft.server.net.handler.PacketHandlerServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import qapy.pepeethings.menu.MenuFurnacePorcelain;
import qapy.pepeethings.util.IPlayer;

@Mixin(PlayerServer.class)
public class PlayerServerMixin implements IPlayer {
	@Shadow
	private void getNextWindowId() {}
	@Shadow
	private int currentWindowId;
	@Shadow
	public PacketHandlerServer playerNetServerHandler;
	@Unique
	private final PlayerServer thisPlayer = (PlayerServer)(Object)this;

	@Override
	public void displayFurnacePorcelainScreen(TileEntityFurnacePorcelain furnacePorcelain) {
		getNextWindowId();
		playerNetServerHandler.sendPacket(new PacketContainerOpen(this.currentWindowId, 2, furnacePorcelain.getNameTranslationKey(), furnacePorcelain.getContainerSize()));
		thisPlayer.containerMenu.onCraftGuiClosed(thisPlayer);
		thisPlayer.containerMenu = new MenuFurnacePorcelain(thisPlayer.inventory, furnacePorcelain);
		thisPlayer.containerMenu.containerId = this.currentWindowId;
		thisPlayer.containerMenu.addSlotListener(thisPlayer);
	}
}
