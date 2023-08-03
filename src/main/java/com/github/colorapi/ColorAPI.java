package com.github.colorapi;

import com.github.colorapi.commands.Commands;
import com.github.colorapi.format.ColorFormat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.github.colorapi.config.ColorConfig;

public final class ColorAPI extends JavaPlugin {
    private ColorConfig colorConfig;
    private ColorFormat colorFormat;
    @Override
    public void onEnable() {

        this.colorConfig = new ColorConfig(this);
        this.colorFormat = new ColorFormat(this);

        getCommand("colorapi").setExecutor(new Commands(this));
    }

    public void reloadPlugin() {
        this.colorConfig = new ColorConfig(this);
        this.colorFormat = new ColorFormat(this);
    }

    // GETTERS

    public ColorFormat getColorFormat() {
        return colorFormat;
    }

    public ColorConfig getColorConfig() {
        return colorConfig;
    }

    public String translateColorCodes(String text) {
        Bukkit.broadcastMessage("COlorAPI OK");
        return colorFormat.formatText(text);
    }
}
