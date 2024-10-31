package xyz.tangledwires.formateverywhere;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.tangledwires.formateverywhere.events.FormatBookText;
import xyz.tangledwires.formateverywhere.events.FormatSignText;

public class FormatEverywhere extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FormatSignText(), this);
        getServer().getPluginManager().registerEvents(new FormatBookText(), this);
        getLogger().info("Enabled " + this.getDescription().getFullName());
    }
    @Override
    public void onDisable() {
        getLogger().info("Disabled " + this.getDescription().getFullName());
    }
}