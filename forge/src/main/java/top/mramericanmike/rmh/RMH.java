package top.mramericanmike.rmh;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import top.mramericanmike.rmh.events.ModClientEventBusSubscriber;
import top.mramericanmike.rmh.setup.ModConfigs;

import static net.minecraftforge.fml.IExtensionPoint.DisplayTest.IGNORESERVERONLY;

@Mod(Constants.MOD_ID)
public class RMH {
    public RMH(FMLJavaModLoadingContext context) {
        context.registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, Constants.MOD_CONFIGS_FILE_NAME + "-client.toml");
        context.registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IGNORESERVERONLY, (a, b) -> true));
    }
}