package com.spectrasonic.givehead;

import org.bukkit.plugin.java.JavaPlugin;
import com.spectrasonic.givehead.commands.GiveHeadCommand;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin {
    private static final String divider = "--------------------";
    private static final String prefix = ChatColor.AQUA + "[GiveHead]" + ChatColor.RESET + " ";

    private final String version = getDescription().getVersion();

    @Override
    public void onEnable() {
        this.getCommand("givehead").setExecutor(new GiveHeadCommand(this));

        getServer().getConsoleSender().sendMessage(divider);
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "GiveHead plugin enabled!");
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.LIGHT_PURPLE + "Version: " + ChatColor.AQUA + version);
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GOLD + "Developed by " + ChatColor.RED + "Spectrasonic");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(divider);
    }

    @Override
    public void onDisable() {

        getServer().getConsoleSender().sendMessage(divider);
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.RED + "GiveHead plugin Disabled successfully!");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(divider);
    }
}