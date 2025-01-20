package top.mramericanmike.rmh.events;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.BarrierBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import top.mramericanmike.rmh.Constants;
import top.mramericanmike.rmh.keybinds.MyKeyMappings;
import top.mramericanmike.rmh.setup.ModConfigs;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
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
        if(ModConfigs.USE_KEY.get() && event.phase == TickEvent.Phase.END) {
            while (MyKeyMappings.RMH.get().consumeClick()) {
                setDoRemove(!isDoRemove());
            }
        }
    }

    @SubscribeEvent
    public static void removeHighlight(final RenderHighlightEvent.Block event) {
        if(event.getTarget().getType().equals(HitResult.Type.BLOCK)){
            BlockHitResult block = event.getTarget();
            if (Minecraft.getInstance().level != null && Minecraft.getInstance().level.getBlockState(block.getBlockPos()).getBlock() instanceof BarrierBlock) {
                event.setCanceled(ModConfigs.INVISIBLE_BARRIER.get());
                return;
            }
        }
        event.setCanceled(isDoRemove());
    }
}
