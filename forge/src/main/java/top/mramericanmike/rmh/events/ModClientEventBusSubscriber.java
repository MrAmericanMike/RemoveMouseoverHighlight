package top.mramericanmike.rmh.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.mramericanmike.rmh.Constants;
import top.mramericanmike.rmh.keybinds.MyKeyMappings;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventBusSubscriber {
    @SubscribeEvent
    public static void onKeyRegister(RegisterKeyMappingsEvent event){
        event.register(MyKeyMappings.RMH.get());
    }
}