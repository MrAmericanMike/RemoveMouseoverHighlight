package mramericanmike.rmh.events;

import mramericanmike.rmh.keybinds.MyKeyMappings;
import mramericanmike.rmh.setup.ModInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModInfo.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientEventBusSubscriber {
	@SubscribeEvent
	public static void onKeyRegister(RegisterKeyMappingsEvent event){
		event.register(MyKeyMappings.RMH.get());
	}
}
