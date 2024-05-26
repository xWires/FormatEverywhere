package xyz.tangledwires.formatsigns;

import org.bukkit.plugin.java.JavaPlugin;

import xyz.tangledwires.formatsigns.events.FormatSignText;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new FormatSignText(), this);
        getLogger().info("Enabled " + this.getDescription().getFullName());
    }
    @Override
    public void onDisable() {
        getLogger().info("Disabled " + this.getDescription().getFullName());
    }
}