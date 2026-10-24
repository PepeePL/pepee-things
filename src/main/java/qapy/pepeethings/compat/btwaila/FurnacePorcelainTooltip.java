package qapy.pepeethings.compat.btwaila;

import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import toufoumaster.btwaila.demo.DemoEntry;
import toufoumaster.btwaila.demo.DemoManager;
import toufoumaster.btwaila.gui.components.AdvancedInfoComponent;
import toufoumaster.btwaila.tooltips.TileTooltip;
import toufoumaster.btwaila.util.ProgressBarOptions;

import java.util.Random;

import static toufoumaster.btwaila.BTWaila.translator;

public class FurnacePorcelainTooltip extends TileTooltip<TileEntityFurnacePorcelain> {
	@Override
	public void initTooltip() {
		addClass(TileEntityFurnacePorcelain.class);
	}
	@Override
	public void drawAdvancedTooltip(TileEntityFurnacePorcelain furnace, AdvancedInfoComponent advancedInfoComponent) {
		ItemStack input = furnace.getItem(0);
		ItemStack fuel = furnace.getItem(1);
		ItemStack output = furnace.getItem(2);

		ProgressBarOptions options = new ProgressBarOptions(0, translator.translateKey("btwaila.tooltip.furnace.progress"), true, true);
		advancedInfoComponent.drawProgressBarWithText(furnace.getCookProgressScaled(100), 100, options, 0);
		ProgressBarOptions speed = new ProgressBarOptions(options.boxWidth, translator.translateKey("btwaila.tooltip.furnace.porcelain.speed") + " ", true, true);
		advancedInfoComponent.drawProgressBarWithText(furnace.getSpeedScaled(1590), 1600, speed, 0);

		advancedInfoComponent.drawStringWithShadow(translator.translateKey("btwaila.tooltip.furnace.burntime").replace("{current}", String.valueOf((int) furnace.currentBurnTime)), 0);
		ItemStack[] stacks = new ItemStack[] {input, fuel, output};
		advancedInfoComponent.drawItemList(stacks, 0);
	}
	@Override
	public DemoEntry tooltipDemo(Random random){
		TileEntityFurnacePorcelain demoFurnace = new TileEntityFurnacePorcelain();
		demoFurnace.setItem(0, DemoManager.randomStack(random));
		demoFurnace.setItem(1, DemoManager.randomStack(random));
		demoFurnace.setItem(2, DemoManager.randomStack(random));
		demoFurnace.currentBurnTime = DemoManager.getRandomFuelTime(random);
		demoFurnace.currentCookTime = random.nextInt(demoFurnace.maxCookTime);
		return new DemoEntry(Blocks.FURNACE_STONE_ACTIVE, 0, demoFurnace, new ItemStack[]{Blocks.FURNACE_STONE_ACTIVE.getDefaultStack()});
	}
}
