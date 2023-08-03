package com.github.colorapi;

import org.bukkit.Bukkit;

public class ColorAPI {

    public static String translateColorCodes(String text) {
        Bukkit.broadcastMessage("COlorAPI OK");
        return ColorAPIPlugin.getInstance().getColorFormat().formatText(text);
    }

}
