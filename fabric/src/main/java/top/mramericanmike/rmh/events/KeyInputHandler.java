package top.mramericanmike.rmh.events;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_RMH = "key.category.rmh";
    public static final String KEY_TOGGLE = "key.rmh.removeMouseoverHighlight";

    public static KeyMapping toggleKey;

    private static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
            if (toggleKey.consumeClick()) {
                RenderOutline.setDoRender(!RenderOutline.isDoRender());
            }
        });
    }

    public static void registerKeys() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(KEY_TOGGLE, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_RMH));
        registerKeyInputs();
    }
}
