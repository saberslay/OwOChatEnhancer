package me.saberslay.owOChatEnhancer.Managers;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CommandManager implements CommandExecutor {
    private final Map<Player, Boolean> playerOwOStatus = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if (label.equalsIgnoreCase("owo")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You cannot do this!");
                return true;
            }
            player = (Player) sender;
            if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
                player.sendMessage(ChatColor.GREEN + "=== owo Command Help ===");
                player.sendMessage(ChatColor.YELLOW + "/owo help: " + ChatColor.WHITE + "Display this help message.");
                player.sendMessage(ChatColor.YELLOW + "/owo <on|off>" + ChatColor.WHITE + "Receive farming items.");
                player.sendMessage(ChatColor.GREEN + "=======================");
                return true;
            } else if (args.length == 1 && args[0].equalsIgnoreCase("on")) {
                playerOwOStatus.put(player, true);
                player.sendMessage(ChatColor.AQUA + "OwO mode enabled.");
                return true;
            } else if (args.length == 1 && args[0].equalsIgnoreCase("off")) {
                playerOwOStatus.put(player, false);
                player.sendMessage(ChatColor.AQUA + "OwO mode disabled.");
                return true;
            }
        }
        return false;
    }
    public boolean isOwOEnabled(Player player) {
        return playerOwOStatus.getOrDefault(player, true);
    }
}