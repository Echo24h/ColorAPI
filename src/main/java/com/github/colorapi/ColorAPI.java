package com.github.colorapi;

import com.github.colorapi.config.ColorConfig;
import com.github.colorapi.format.ColorFormat;

public class ColorAPI {

    private ColorAPIPlugin plugin;
    private ColorConfig colorConfig;
    private ColorFormat colorFormat;

    public ColorAPI(ColorAPIPlugin plugin) {
        this.plugin = plugin;
        this.colorConfig = new ColorConfig(plugin);
        this.colorFormat = new ColorFormat(this);
    }

    public String translateColorCodes(String text) {
        return colorFormat.formatText(text);
    }

    public ColorConfig getColorConfig() {
        return colorConfig;
    }
}
