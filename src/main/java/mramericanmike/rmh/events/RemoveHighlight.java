package mramericanmike.rmh.events;

import mramericanmike.rmh.setup.ModConfigs;
import net.minecraftforge.client.event.DrawSelectionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RemoveHighlight {

	private static boolean doRemove = ModConfigs.DEFAULT_STATE.get();

	@SubscribeEvent
	public static void removeHighlight(final DrawSelectionEvent event) {
		if(isDoRemove()) {
			event.setCanceled(true);
		}
	}

	public static boolean isDoRemove() {
		return doRemove;
	}

	public static void setDoRemove(boolean doRemove) {
		RemoveHighlight.doRemove = doRemove;
	}

}
