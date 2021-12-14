package mramericanmike.rmh.keybinds;

import mramericanmike.rmh.events.RemoveHighlight;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class KeyMonitor {

	public KeyMonitor(){}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(MyKeyMappings.rmh.isDown()){
			RemoveHighlight.setDoRemove(!RemoveHighlight.isDoRemove());
		}
	}
}
