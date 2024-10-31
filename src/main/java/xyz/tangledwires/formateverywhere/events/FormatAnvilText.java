package xyz.tangledwires.formateverywhere.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import xyz.tangledwires.formateverywhere.FormatEverywhere;

public class FormatAnvilText implements Listener {
    @EventHandler
    public void onAnvilPrepare(PrepareAnvilEvent event) {
        FormatEverywhere plugin = (FormatEverywhere) Bukkit.getServer().getPluginManager().getPlugin("FormatEverywhere");
        if (!plugin.getConfig().getBoolean("itemNameFormatting", false)) {
            return;
        }

        ItemStack oldResult = event.getResult();
        if (oldResult != null) {
            ItemStack newResult = oldResult.clone();
            ItemMeta im = newResult.getItemMeta();
            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', im.getDisplayName()));
            newResult.setItemMeta(im);
            event.setResult(newResult);
        }
    }
}
