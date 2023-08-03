package com.github.colorapi;

import org.bukkit.Bukkit;

public class ColorAPI {

    public String translateColorCodes(ColorAPIPlugin plugin, String text) {
        Bukkit.broadcastMessage("COlorAPI OK");
        return ColorAPIPlugin.getInstance().getColorFormat().formatText(text);
    }
}
