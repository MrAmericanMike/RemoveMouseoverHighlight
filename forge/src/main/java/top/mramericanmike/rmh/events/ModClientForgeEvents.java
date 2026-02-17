package top.mramericanmike.rmh.events;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.BarrierBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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
        if(ModConfigs.USE_KEY.get()){
            if (event.phase == TickEvent.Phase.END) {
                while (MyKeyMappings.RMH.get().consumeClick()) {
                    setDoRemove(!isDoRemove());
                }
            }
        }
    }

    @SubscribeEvent
    public static void removeHighlight(final RenderHighlightEvent event) {
        if(event.getTarget().getType().equals(HitResult.Type.BLOCK)){
            BlockHitResult block = (BlockHitResult) event.getTarget();
            if (Minecraft.getInstance().level != null && Minecraft.getInstance().level.getBlockState(block.getBlockPos()).getBlock() instanceof BarrierBlock) {
                event.setCanceled(ModConfigs.INVISIBLE_BARRIER.get());
                return;
            }
        }
        event.setCanceled(isDoRemove());
    }
}
