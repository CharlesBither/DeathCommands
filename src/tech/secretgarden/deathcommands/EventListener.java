package tech.secretgarden.deathcommands;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;

public class EventListener implements Listener {

    private final Main plugin;
    public EventListener(Main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void death(PlayerDeathEvent e) {
        List<String> commandsList = (List<String>) plugin.getConfig().getList("commands");

        for (String entry : commandsList) {
            //plugin.getConfig().getString("commands").replace("%player%", e.getEntity().toString());
            ConsoleCommandSender console = plugin.getServer().getConsoleSender();
            entry = entry.replace("%player%", e.getEntity().getDisplayName());
            plugin.getServer().dispatchCommand(console, entry);
        }
    }
}
