package mramericanmike.rmh;

import mramericanmike.rmh.setup.ModConfigs;
import mramericanmike.rmh.setup.ModInfo;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import static net.minecraftforge.fml.IExtensionPoint.DisplayTest.IGNORESERVERONLY;


@Mod(ModInfo.MOD_ID)
public class RMH {
	public RMH(){
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IGNORESERVERONLY, (a, b) -> true));
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, "RemoveMouseoverHighlight-client.toml");
	}
}
