package xyz.tangledwires.formatsigns.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import net.md_5.bungee.api.ChatColor;

public class FormatSignText implements Listener {
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        int index = 0;
        for (String s : event.getLines()) {
            event.setLine(index, ChatColor.translateAlternateColorCodes('&', s));
            index++;
        }
    }
}
