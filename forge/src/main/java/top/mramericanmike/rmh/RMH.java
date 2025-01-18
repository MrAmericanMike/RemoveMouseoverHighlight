package top.mramericanmike.rmh;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.mramericanmike.rmh.setup.ModConfigs;

import static net.minecraftforge.fml.IExtensionPoint.DisplayTest.IGNORESERVERONLY;

@Mod(Constants.MOD_ID)
public class RMH {
    public RMH(FMLJavaModLoadingContext context) {
        context.registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IGNORESERVERONLY, (a, b) -> true));
        context.registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, "RemoveMouseoverHighlight-client.toml");
    }
}