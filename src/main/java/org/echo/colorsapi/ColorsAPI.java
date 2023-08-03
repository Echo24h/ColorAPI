package org.echo.colorsapi;

import org.bukkit.plugin.java.JavaPlugin;
import org.echo.colorsapi.commands.Commands;
import org.echo.colorsapi.config.ColorsConfig;
import org.echo.colorsapi.format.ColorsFormat;

public final class ColorsAPI extends JavaPlugin {

    private ColorsConfig colorsConfig;
    private ColorsFormat colorsFormat;
    @Override
    public void onEnable() {

        this.colorsConfig = new ColorsConfig(this);
        this.colorsFormat = new ColorsFormat(this);

        getCommand("colorsapi").setExecutor(new Commands(this));
    }

    public void reloadPlugin() {
        this.colorsConfig = new ColorsConfig(this);
        this.colorsFormat = new ColorsFormat(this);
    }

    public String translateColorCodes(String text) {
        return colorsFormat.formatText(text);
    }

    // GETTERS

    public ColorsFormat getColorsFormat() {
        return colorsFormat;
    }

    public ColorsConfig getColorsConfig() {
        return colorsConfig;
    }
}
