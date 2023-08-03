package com.github.colorapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ColorAPI {

    public static String translateColorCodes(String text) {
        Bukkit.broadcastMessage("COlorAPI OK");
        return JavaPlugin.getPlugin(ColorAPIPlugin.class).getColorFormat().formatText(text);
    }

}
