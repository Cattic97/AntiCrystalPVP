package me.savag3.anti.crystal;

import lombok.Getter;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Savag3life
 * @since 1.0
 * Simple object config file.
 */
@ConfigSerializable
public class Config {

    @Getter private boolean disableGlobalCrystalExplosionDamage = true;
    @Getter private List<String> worldList = Arrays.asList("world_nether", "world_the_end");

}
