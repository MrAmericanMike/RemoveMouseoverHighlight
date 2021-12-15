package mramericanmike.rmh;

import mramericanmike.rmh.events.RemoveHighlight;
import mramericanmike.rmh.keybinds.KeyMonitor;
import mramericanmike.rmh.keybinds.MyKeyMappings;
import mramericanmike.rmh.setup.ModConfigs;
import mramericanmike.rmh.setup.ModInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod(ModInfo.MOD_ID)
public class RMH
{
    public RMH() {
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        //MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, "RemoveMouseoverHighlight-client.toml");
        MinecraftForge.EVENT_BUS.register(RemoveHighlight.class);
        if(ModConfigs.USE_KEY.get()){
            MinecraftForge.EVENT_BUS.register(new KeyMonitor());
            MyKeyMappings.register();
        }
    }
}
