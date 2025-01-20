package top.mramericanmike.rmh;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import top.mramericanmike.rmh.setup.ModConfigs;

import static net.minecraftforge.fml.IExtensionPoint.DisplayTest.IGNORESERVERONLY;

@Mod(Constants.MOD_ID)
public class RMH {
    public RMH() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, Constants.MOD_CONFIGS_FILE_NAME + "-client.toml");
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IGNORESERVERONLY, (a, b) -> true));
    }
}