package top.mramericanmike.rmh;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.BarrierBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import top.mramericanmike.rmh.setup.ModConfigs;
import top.mramericanmike.rmh.events.KeyInputHandler;
import top.mramericanmike.rmh.events.RenderOutline;

public class RMH implements ClientModInitializer{
    
    @Override
    public void onInitializeClient() {
        ModConfigs.register();
        RenderOutline.setDoRender(!ModConfigs.default_state);
        KeyInputHandler.registerKeys();

        WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((worldRenderContext, hitResult) -> {
            if (hitResult != null && hitResult.getType().equals(HitResult.Type.BLOCK)) {
                BlockHitResult bhr = (BlockHitResult) hitResult;
                if (Minecraft.getInstance().level != null && Minecraft.getInstance().level.getBlockState(bhr.getBlockPos()).getBlock() instanceof BarrierBlock) {
                    return !ModConfigs.invisible_barrier;
                }
            }
            return RenderOutline.doRenderOutline();
        });
    }
}
