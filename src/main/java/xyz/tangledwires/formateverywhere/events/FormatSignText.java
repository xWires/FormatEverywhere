package xyz.tangledwires.formateverywhere.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import net.md_5.bungee.api.ChatColor;
import xyz.tangledwires.formateverywhere.FormatEverywhere;

public class FormatSignText implements Listener {
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        FormatEverywhere plugin = (FormatEverywhere) Bukkit.getServer().getPluginManager().getPlugin("FormatEverywhere");
        if (!plugin.getConfig().getBoolean("signFormatting", false)) {
            return;
        }

        int index = 0;
        for (String s : event.getLines()) {
            event.setLine(index, ChatColor.translateAlternateColorCodes('&', s));
            index++;
        }
    }
}
