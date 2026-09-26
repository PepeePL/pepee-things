package qapy.pepeethings.item;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;

public class ItemFoodPortioned extends ItemFood {
	public ItemFoodPortioned(String name, String namespaceId, int id, int healAmount, int ticksPerHeal, int usages) {
		super(name, namespaceId, id, healAmount, ticksPerHeal, false, 1);
		this.setMaxDamage(usages);
	}

	@Override
	public ItemStack onUse(@NotNull ItemStack itemStack, @NotNull World world, Player entityplayer) {
		if (entityplayer.getHealth() < entityplayer.getMaxHealth() && entityplayer.getHealth() + entityplayer.getTotalHealingRemaining() < entityplayer.getMaxHealth()) {
			entityplayer.eatFood(this.getDefaultStack());
			itemStack.damageItem(1, entityplayer);
			world.playSoundAtEntity(entityplayer, entityplayer, this.getTicksPerHeal(this.getDefaultStack()) >= 10 ? "random.bite_extended" : "random.bite", 0.5F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.1F, 1.1F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.1F);
			if (itemStack.getMetadata() == getMaxDamage()) itemStack.consumeItem(entityplayer);
		}
		return itemStack;
	}
}
