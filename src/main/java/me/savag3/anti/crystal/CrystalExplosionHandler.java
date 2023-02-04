package me.savag3.anti.crystal;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * @author Savag3life
 * @since 1.0
 */
public class CrystalExplosionHandler implements Listener {

    private final AntiCrystalPVP plugin;

    public CrystalExplosionHandler(AntiCrystalPVP plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void handlePlayerDamage(EntityDamageByEntityEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            if (e.getDamager().getType() == EntityType.ENDER_CRYSTAL) {
                if (e.getEntity() instanceof Player) {

                    final String worldName = e.getEntity().getWorld().getName();
                    if (plugin.getConf().isDisableGlobalCrystalExplosionDamage()) {
                        if (plugin.getConf().getWorldList().contains(worldName)) {
                            return;
                        }
                    } else {
                        if (!plugin.getConf().getWorldList().contains(worldName)) {
                            return;
                        }
                    }

                    e.setCancelled(true);
                }
            }
        }
    }

}
