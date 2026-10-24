package qapy.pepeethings.compat.btwaila;

import org.slf4j.Logger;
import qapy.pepeethings.block.entity.TileEntityFurnacePorcelain;
import toufoumaster.btwaila.entryplugins.waila.BTWailaCustomTooltipPlugin;
import toufoumaster.btwaila.tooltips.TileTooltip;
import toufoumaster.btwaila.tooltips.TooltipRegistry;

import static toufoumaster.btwaila.entryplugins.waila.BTWailaPlugin.registry;

public class BTWailaPlugin implements BTWailaCustomTooltipPlugin {
	public static TileTooltip<TileEntityFurnacePorcelain> FURNACE_PORCELAIN = registry.register(new FurnacePorcelainTooltip());
	@Override
	public void initializePlugin(TooltipRegistry registry, Logger logger) {
		logger.info("BTWaila detected, registering Pepee's Things tooltips.");
	}
}
