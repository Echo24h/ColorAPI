package com.github.colorapi.config;

import com.github.colorapi.ColorAPIPlugin;
import com.github.colorapi.format.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorConfig {

    private ColorAPIPlugin plugin;

    private YamlConfiguration yaml;

    private Map<String, ChatColor> colors;

    private Map<String, List<String>> gradients;

    private String colorsCode;

    public ColorConfig(ColorAPIPlugin plugin) {

        colorsCode = "abcdef0123456789";

        this.plugin = plugin;

        colors = new HashMap<>();
        gradients = new HashMap<>();

        this.yaml = loadConfig("colors.yml");
        loadColors();
        loadGradients();
    }

    public String getColorsCode() {
        return colorsCode;
    }

    public ChatColor getColor(String colorCode) {

        ChatColor color = colors.get(colorCode);
        if (color == null) {
            color = ChatColor.getByChar(colorCode.charAt(0));
        }
        return color;
    }

    public List<String> getGradient(String colorsCode) {
        return gradients.get(colorsCode);
    }

    private YamlConfiguration loadConfig(String filename) {

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        File file = new File(plugin.getDataFolder(), filename);

        if (!file.exists()) {
            plugin.saveResource(filename, false);
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    private void loadColors() {

        ConfigurationSection colorsSection;

        colorsSection = yaml.getConfigurationSection("colors");

        if (colorsSection != null) {
            for (String key : colorsSection.getKeys(false)) {
                ConfigurationSection colorSection = colorsSection.getConfigurationSection(key);
                if (colorSection != null) {

                    colorsCode = colorsCode + key;

                    String hexColor = colorSection.getString("color");

                    ChatColor color = ChatColor.of(Utils.hexToRgb(hexColor));

                    colors.put(key, color);
                }
            }
        }
    }

    private void loadGradients() {

        ConfigurationSection colorsSection;

        colorsSection = yaml.getConfigurationSection("gradients");

        if (colorsSection != null) {
            for (String key : colorsSection.getKeys(false)) {
                ConfigurationSection colorSection = colorsSection.getConfigurationSection(key);
                if (colorSection != null) {

                    colorsCode = colorsCode + key;

                    String hexColor1 = colorSection.getString("color1");
                    String hexColor2 = colorSection.getString("color2");

                    List<String> hexColors = new ArrayList<>();
                    hexColors.add(hexColor1);
                    hexColors.add(hexColor2);
                    gradients.put(key, hexColors);
                }
            }
        }
    }
}
