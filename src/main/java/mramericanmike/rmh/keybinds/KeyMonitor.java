package mramericanmike.rmh.keybinds;

import mramericanmike.rmh.events.RemoveHighlight;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class KeyMonitor {

	public KeyMonitor(){}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		if(minecraft.level != null && minecraft.screen == null && MyKeyMappings.rmh.isDown()){
			RemoveHighlight.setDoRemove(!RemoveHighlight.isDoRemove());
		}
	}
}
