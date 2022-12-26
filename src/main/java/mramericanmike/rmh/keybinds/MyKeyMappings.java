package mramericanmike.rmh.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import mramericanmike.rmh.setup.ModInfo;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class MyKeyMappings {
	public static final String KEY_CATEGORY_RMH = "key.category." + ModInfo.MOD_ID;
	public static final String KEY_RMH = "key." + ModInfo.MOD_ID + ".removeMouseoverHighlight";

	public static final Lazy<KeyMapping> RMH = Lazy.of(() -> new KeyMapping(KEY_RMH, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_RMH));

}
