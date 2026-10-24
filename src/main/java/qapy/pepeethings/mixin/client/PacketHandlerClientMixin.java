package qapy.pepeethings.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.net.handler.PacketHandlerClient;
import net.minecraft.core.net.packet.PacketContainerOpen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import qapy.pepeethings.util.IPlayer;

import java.util.Objects;

@Mixin(PacketHandlerClient.class)
public class PacketHandlerClientMixin {
	@Final
	@Shadow
	private Minecraft mc;
	@Inject(method = "handleContainerOpen", at = @At("HEAD"), cancellable = true)
	public void handleContainerOpen(PacketContainerOpen packetContainerOpen, CallbackInfo ci) {
		if (Objects.equals(packetContainerOpen.windowTitle, "container.furnace.porcelain.name")){
			if(mc.thePlayer instanceof IPlayer player) {
				TileEntityFurnacePorcelain tileEntityFurnacePorcelain = new TileEntityFurnacePorcelain();
				player.displayFurnacePorcelainScreen(tileEntityFurnacePorcelain);
				mc.thePlayer.containerMenu.containerId = packetContainerOpen.windowId;
				ci.cancel();
			}
		}
	}
}
