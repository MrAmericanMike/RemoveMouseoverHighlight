package mramericanmike.rmh.events;

import mramericanmike.rmh.keybinds.MyKeyMappings;
import mramericanmike.rmh.setup.ModConfigs;
import mramericanmike.rmh.setup.ModInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModInfo.MOD_ID, value = Dist.CLIENT)
public class ModClientForgeEvents {

		private static boolean doRemove = true;

		private static boolean isDoRemove() {
			return doRemove;
		}

		private static void setDoRemove(boolean newDoRemove) {
			doRemove = newDoRemove;
		}

		@SubscribeEvent
		public static void playerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event){
			setDoRemove(ModConfigs.DEFAULT_STATE.get());
		}

		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				while (MyKeyMappings.RMH.get().consumeClick()) {
					if(ModConfigs.USE_KEY.get()){
						setDoRemove(!isDoRemove());
					}
				}
			}
		}

		@SubscribeEvent
		public static void removeHighlight(final RenderHighlightEvent event) {
			if(isDoRemove()) {
				event.setCanceled(true);
			}
		}
}
