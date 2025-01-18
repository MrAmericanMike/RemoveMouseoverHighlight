package top.mramericanmike.rmh;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.javafmlmod.FMLModContainer;
import top.mramericanmike.rmh.setup.ModConfigs;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public class RMH {

    public RMH(FMLModContainer container, IEventBus iEventBus, Dist dist) {
        container.registerConfig(ModConfig.Type.CLIENT, ModConfigs.SPEC, "RemoveMouseoverHighlight-client.toml");
    }
}