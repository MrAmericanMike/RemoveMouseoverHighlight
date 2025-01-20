package top.mramericanmike.rmh;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import top.mramericanmike.rmh.setup.ModConfigs;

import static net.neoforged.fml.IExtensionPoint.DisplayTest.IGNORESERVERONLY;

@Mod(value = Constants.MOD_ID)
public class RMH {
    public RMH(FMLModContainer container, IEventBus iEventBus, Dist dist) {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, Constants.MOD_CONFIGS_FILE_NAME + "-client.toml");
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> IGNORESERVERONLY, (a, b) -> true));
    }
}