package top.mramericanmike.rmh.setup;

import net.fabricmc.loader.api.FabricLoader;
import top.mramericanmike.rmh.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ModConfigs {
    private static final Path CONFIGS_PATH = FabricLoader.getInstance().getConfigDir().resolve(Constants.MOD_CONFIGS_FILE_NAME + "-client.properties");
    private static final String DEFAULT_STATE_KEY = "default_state";
    private static final String USE_KEY_TOGGLE_KEY = "use_key_toggle";
    private static final String INVISIBLE_BARRIER_KEY = "invisible_barrier";

    public static boolean default_state = true;
    public static boolean use_key_toggle = true;
    public static boolean invisible_barrier = false;

    public static void register() {
        Properties properties = new Properties();
        if (!Files.exists(CONFIGS_PATH)) {
            try {
                Files.createFile(CONFIGS_PATH);
                saveProperties(properties);
            } catch (IOException e) {
                Constants.LOG.error("Failed to create configuration file!");
                e.printStackTrace();
                return;
            }
        } else {
            try {
                properties.load(Files.newInputStream(CONFIGS_PATH));
            } catch (IOException e) {
                Constants.LOG.error("Failed to read configuration file!");
                e.printStackTrace();
            }
        }
        readProperties(properties);
        saveProperties(properties);
    }

    private static void saveProperties(Properties properties) {
        properties.setProperty(USE_KEY_TOGGLE_KEY, Boolean.toString(use_key_toggle));
        properties.setProperty(DEFAULT_STATE_KEY, Boolean.toString(default_state));
        properties.setProperty(INVISIBLE_BARRIER_KEY, Boolean.toString(invisible_barrier));
        try {
            properties.store(Files.newOutputStream(CONFIGS_PATH), "Configuration file");
        } catch (IOException e) {
            Constants.LOG.error("Failed to write to configuration file!");
            e.printStackTrace();
        }
    }

    private static void readProperties(Properties properties) {
        default_state = defaultedBool(properties.getProperty(DEFAULT_STATE_KEY), default_state);
        use_key_toggle = defaultedBool(properties.getProperty(USE_KEY_TOGGLE_KEY), use_key_toggle);
        invisible_barrier = defaultedBool(properties.getProperty(INVISIBLE_BARRIER_KEY), invisible_barrier);
    }

    private static boolean bool(String bool) {
        return bool != null && bool.equalsIgnoreCase("true");
    }

    private static boolean defaultedBool(String bool, boolean defaultValue) {
        return bool == null ? defaultValue : bool(bool);
    }
}
