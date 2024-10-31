package xyz.tangledwires.formateverywhere;

import org.bstats.bukkit.Metrics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import xyz.tangledwires.formateverywhere.events.FormatAnvilText;
import xyz.tangledwires.formateverywhere.events.FormatBookText;
import xyz.tangledwires.formateverywhere.events.FormatSignText;

public class FormatEverywhere extends JavaPlugin {
    @Override
    public void onEnable() {
        int pluginId = 23773;
        @SuppressWarnings("unused")
        Metrics metrics = new Metrics(this, pluginId);

        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new FormatSignText(), this);
        getServer().getPluginManager().registerEvents(new FormatBookText(), this);
        getServer().getPluginManager().registerEvents(new FormatAnvilText(), this);

        getLogger().info("Enabled " + this.getDescription().getFullName());
    }
    @Override
    public void onDisable() {
        getLogger().info("Disabled " + this.getDescription().getFullName());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("formateverywhere")) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    this.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "Config reloaded!");
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}