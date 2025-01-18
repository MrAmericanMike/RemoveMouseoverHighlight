package top.mramericanmike.rmh.setup;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfigs {

    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue USE_KEY;
    public static final ModConfigSpec.BooleanValue DEFAULT_STATE;
    public static final ModConfigSpec.BooleanValue INVISIBLE_BARRIER;

    static {
        final var BUILDER = new ModConfigSpec.Builder();
        BUILDER.push("Remove Mouseover Highlight Configs");
        USE_KEY = BUILDER.comment("Enables 1 key press to toggle this mod functionality").define("Use key toggle", true);
        DEFAULT_STATE = BUILDER.comment("Default State for Remove Mouseover Highlight - true = ON (Invisible Highlight) // false = OFF (Visible Highlight)").define("Default State", true);
        INVISIBLE_BARRIER = BUILDER.comment("Makes the barrier always invisible (Barriers ignore other settings)").define("Invisible Barrier", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
