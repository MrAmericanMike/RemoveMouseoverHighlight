package top.mramericanmike.rmh.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import top.mramericanmike.rmh.Constants;
import top.mramericanmike.rmh.keybinds.MyKeyMappings;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientEventBusSubscriber {
    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event){
        event.register(MyKeyMappings.RMH.get());
    }
}
