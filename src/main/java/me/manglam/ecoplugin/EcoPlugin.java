package me.manglam.ecoplugin;

import me.manglam.ecoplugin.commands.EconomyCommand;
import me.manglam.ecoplugin.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class EcoPlugin extends JavaPlugin {

    private static EcoPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        getCommand("eco").setExecutor(new EconomyCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static EcoPlugin getInstance() {
        return instance;
    }
}

