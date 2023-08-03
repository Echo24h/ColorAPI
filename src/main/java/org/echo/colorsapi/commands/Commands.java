package org.echo.colorsapi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.echo.colorsapi.ColorsAPI;

public class Commands implements CommandExecutor {

    private ColorsAPI plugin;

    public Commands(ColorsAPI main) { this.plugin = main; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("colorsapi.reload")) {
                    player.sendMessage("§cYou not have permission");
                    return true;
                }
            }
            plugin.reloadPlugin();
            sender.sendMessage("§a[ColorsAPI] successfully reloaded.");
            return true;
        }
        return false;
    }
}