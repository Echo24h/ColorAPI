package com.github.colorapi;

import com.github.colorapi.commands.Commands;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public final class ColorAPIPlugin extends JavaPlugin {

    public ColorAPI colorAPI;

    @Override
    public void onLoad() {
        colorAPI = new ColorAPI(this);
        getServer().getServicesManager().register(ColorAPI.class, colorAPI, this, ServicePriority.High);
    }
    @Override
    public void onEnable() {
        getCommand("colorapi").setExecutor(new Commands(this));
    }

    @Override
    public void onDisable() {
        getServer().getServicesManager().unregister(this.colorAPI);
    }

    public void reloadPlugin() {
        colorAPI = new ColorAPI(this);
    }
}
