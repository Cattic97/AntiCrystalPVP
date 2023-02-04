package me.savag3.anti.crystal.configurate;

import lombok.experimental.UtilityClass;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.NodeStyle;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Savag3life
 * @since 1.0
 */
@UtilityClass
public class ConfigLoader {

    @SuppressWarnings("unchecked")
    public <T> T load(Path path, Class<T> configInstance) {
        try {
            YamlConfigurationLoader loader = getLoader(path);

            if (!Files.exists(path)) {
                Files.createFile(path);
                try {
                    T instance = (T) configInstance.getDeclaredConstructors()[0].newInstance();
                    CommentedConfigurationNode node = loader.load();
                    node.set(configInstance, instance);
                    loader.save(node);

                    return instance;
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            ConfigurationNode node = loader.load();
            T t = node.get(configInstance);
            loader.save(node);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static YamlConfigurationLoader getLoader(Path path) {
        YamlConfigurationLoader.Builder builder = YamlConfigurationLoader.builder()
                .indent(2)
                .nodeStyle(NodeStyle.BLOCK)
                .source(() -> Files.newBufferedReader(path, StandardCharsets.UTF_8))
                .sink(() -> Files.newBufferedWriter(path, StandardCharsets.UTF_8));

        builder.defaultOptions();
        return builder.build();
    }
}