package qapy.pepeethings.mixin;

import com.b100.utils.StringUtils;
import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.animal.MobChicken;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import qapy.pepeethings.ModItems;

@Mixin(value = Mob.class, remap = false)
public abstract class MobMixin {
	@Shadow
	public byte chatColor;
	@Shadow
	public abstract void setNickname(@NotNull String nickname);
	/**
	 * @author Pepee
	 * @reason Custom interact for catching chicken with net.
	 */
	@Overwrite
	public boolean interact(@NotNull Player player) {
		ItemStack item = player.inventory.getCurrentItem();
		if (item != null && item.itemID == Items.LABEL.id && item.hasCustomName()) {
			if (item.hasCustomColor()) {
				this.chatColor = item.getCustomColor();
			} else {
				this.chatColor = 0;
			}
			this.setNickname(StringUtils.substring(item.getCustomName(), 0, 32));
			return false;
		}else if ((Object) this instanceof MobChicken) {
			chickenInteract(player);
		} else {
			return false;
		}
		return false;
	}

	private boolean chickenInteract(@NotNull Player player) {
		ItemStack item = player.inventory.getCurrentItem();
		if (item != null && item.itemID == ModItems.NET.id) {
			if (item.getMetadata() == 0){
				item.setMetadata(1);
				CompoundTag tag = new CompoundTag();
				((MobChicken)(Object)this).save(tag);
				item.setData(tag);
				((MobChicken)(Object)this).remove();
				return true;
			}
		}
		return false;
	}
}
