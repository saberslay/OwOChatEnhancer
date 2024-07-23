package me.saberslay.owOChatEnhancer;

import me.saberslay.owOChatEnhancer.Managers.EventManager;
import me.saberslay.owOChatEnhancer.utile.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class OwOChatEnhancer extends JavaPlugin implements Listener  {
    @Override
    public void onEnable() {
        // Register the event listener
        getServer().getPluginManager().registerEvents(new EventManager(this), this);
        // need to sort out the command stuff
        //getCommand("owo").setExecutor(new CommandManager());

        getLogger().info(ChatColor.translateAlternateColorCodes('&',"OwO Chat Enhancer Plugin has been enabled!"));

        new UpdateChecker(this, 118283).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&6OwO Chat Enhancer plugin is up to date"));
            } else {
                getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&6OwO Chat Enhancer plugin has an update available"));
            }
        });
        
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"&6OwO Chat Enhancer has Loaded"));

    }

    @Override
    public void onDisable() {
        getLogger().info("OwO Chat Enhancer Plugin has been disabled!");
    }

}
