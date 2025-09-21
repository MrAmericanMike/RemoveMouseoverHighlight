package top.mramericanmike.rmh.setup;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> USE_KEY;
    public static final ForgeConfigSpec.ConfigValue<Boolean> DEFAULT_STATE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> INVISIBLE_BARRIER;

    static {
        BUILDER.push("Remove Mouseover Highlight Configs");
        USE_KEY = BUILDER.comment("Enables one key press to toggle this mod functionality").define("Use key toggle", true);
        DEFAULT_STATE = BUILDER.comment("Default State for Remove Mouseover Highlight - true = ON (Invisible Highlight) // false = OFF (Visible Highlight)").define("Default State", true);
        INVISIBLE_BARRIER = BUILDER.comment("Makes the barrier always invisible (Barriers ignore other settings)").define("Invisible Barrier", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
