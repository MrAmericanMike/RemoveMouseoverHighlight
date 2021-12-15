package mramericanmike.rmh.keybinds;

import mramericanmike.rmh.setup.ModInfo;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.awt.event.KeyEvent;

public class MyKeyBindings {
	public static KeyBinding rmh;

	public static void register(){
		rmh = registerKey("removeMouseoverHighlight", KeyEvent.VK_H);

	}

	private static KeyBinding registerKey(String name, int key){
		KeyBinding keyBinding = new KeyBinding("key." + ModInfo.MOD_ID + "." + name, key, "key.category." + ModInfo.MOD_ID);
		ClientRegistry.registerKeyBinding(keyBinding);
		return keyBinding;
	}
}
