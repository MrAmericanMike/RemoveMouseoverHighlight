package top.mramericanmike.rmh.events;

import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import top.mramericanmike.rmh.keybinds.MyKeyMappings;
import top.mramericanmike.rmh.setup.ModConfigs;

public class ModClientEventBusSubscriber {
    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event){
        if(ModConfigs.USE_KEY.get()){
            event.register(MyKeyMappings.RMH.get());
        }
    }
}