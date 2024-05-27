package xyz.tangledwires.formateverywhere.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.meta.BookMeta;

import net.md_5.bungee.api.ChatColor;

public class FormatBookText implements Listener {
    @EventHandler
    public void onBookEdit(PlayerEditBookEvent event) {
        BookMeta meta = event.getNewBookMeta();
        List<String> pages = meta.getPages();
        List<String> newPages = new ArrayList<>();

        for (String page : pages) {
            newPages.add(ChatColor.translateAlternateColorCodes('&', page));
        }

        meta.setPages(newPages);

        event.setNewBookMeta(meta);
    }
}
