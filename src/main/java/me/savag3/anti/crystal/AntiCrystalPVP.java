package me.savag3.anti.crystal;

import lombok.Getter;
import me.savag3.anti.crystal.configurate.ConfigLoader;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Savag3life
 * @since 1.0
 */
public class AntiCrystalPVP extends JavaPlugin {

    // Can't call it config because JavaPlugin#getConfig() :3
    @Getter private Config conf;

    @Override
    public void onEnable() {
        getLogger().info("Attempting to enable AntiCrystalPVP...");
        // Plugin startup logic
        getDataFolder().mkdirs();
        this.conf = ConfigLoader.load(getDataFolder().toPath().resolve("config.yml"), Config.class);
        new CrystalExplosionHandler(this);
        getLogger().info("AntiCrystalPVP has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("AntiCrystalPVP has been disabled!");
    }
}
