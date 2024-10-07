package com.spectrasonic.givehead.commands;

import com.spectrasonic.givehead.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GiveHeadCommand implements CommandExecutor {

    private final Main plugin;

    public GiveHeadCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if sender is a player
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) {
                player.sendMessage(ChatColor.GREEN + "GiveHead Plugin Version: " + ChatColor.AQUA + plugin.getDescription().getVersion());
                return true;
            }

            String playerName = args[0];
            Player target = Bukkit.getPlayer(playerName);

            // Check if the player exists (online or not)
            if (target == null) {
                player.sendMessage(ChatColor.RED + "Player " + playerName + " is not online or does not exist.");
                return true;
            }

            // Create the player's head item
            ItemStack playerHead = new ItemStack(org.bukkit.Material.PLAYER_HEAD, 1);
            SkullMeta skullMeta = (SkullMeta) playerHead.getItemMeta();
            assert skullMeta != null;
            skullMeta.setOwningPlayer(target);
            skullMeta.setDisplayName(ChatColor.GOLD + target.getName() + "'s Head");
            playerHead.setItemMeta(skullMeta);

            // Give the head to the player
            player.getInventory().addItem(playerHead);
            player.sendMessage(ChatColor.GREEN + "You have been given " + ChatColor.GOLD + target.getName() + "'s Head!");
            return true;
        }

        // If the command was used without arguments or incorrect usage
        player.sendMessage(ChatColor.RED + "Usage: /givehead <playername> or /givehead version");
        return true;
    }
}
