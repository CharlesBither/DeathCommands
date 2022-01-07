package tech.secretgarden.deathcommands;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("DeathCommands is enabled");
        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        List<String> commandsList = (List<String>) getConfig().getList("commands");
    }

    @Override
    public void onDisable() {
        System.out.println("DeathCommands is disabled");

    }
}
