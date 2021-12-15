package mramericanmike.rmh.keybinds;

import mramericanmike.rmh.setup.ModInfo;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.fmlclient.registry.ClientRegistry;

import java.awt.event.KeyEvent;

public class MyKeyMappings {
	public static KeyMapping rmh;

	public static void register(){
		rmh = registerKey("removeMouseoverHighlight", KeyEvent.VK_H);
	}

	private static KeyMapping registerKey(String name, int key){
		final var keyMapping = new KeyMapping("key." + ModInfo.MOD_ID + "." + name, key, "key.category." + ModInfo.MOD_ID);
		ClientRegistry.registerKeyBinding(keyMapping);
		return keyMapping;
	}
}
