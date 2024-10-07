package com.spectrasonic.givehead;

import org.bukkit.plugin.java.JavaPlugin;
import com.spectrasonic.givehead.commands.GiveHeadCommand;
import org.bukkit.ChatColor;

public class Main extends JavaPlugin {
    private static final String divider = "--------------------";
    private static final String prefix = ChatColor.AQUA + "[GiveHead]"+ ChatColor.RESET + " ";

    @Override
    public void onEnable() {
        this.getCommand("givehead").setExecutor(new GiveHeadCommand(this));
        getLogger().info(divider);
        getLogger().info("");
        getLogger().info(ChatColor.GREEN + "GiveHead plugin enabled!");
        getLogger().info(ChatColor.GOLD + "Developed by " + ChatColor.RED + "Spectrasonic");
        getLogger().info("");
        getLogger().info(divider);
    }

    @Override
    public void onDisable() {
        getLogger().info(divider);
        getLogger().info("");
        getLogger().info(ChatColor.RED + "GiveHead plugin Disabled successfully!");
        getLogger().info("");
        getLogger().info(divider);
    }
}
