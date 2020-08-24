package net.lapismc.afkpluseventcommands;

import net.lapismc.afkplus.api.AFKActionEvent;
import net.lapismc.afkplus.api.AFKStartEvent;
import net.lapismc.afkplus.api.AFKStopEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AFKPlusEventCommands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info(getName() + " v." + getDescription().getVersion() + " has been enabled");
    }

    @EventHandler
    public void onAFKStart(AFKStartEvent e) {
        if (!getConfig().contains("AFKStart"))
            return;
        for (String command : getConfig().getStringList("AFKStart")) {
            runCommand(command, Bukkit.getPlayer(e.getPlayer().getUUID()));
        }
    }

    @EventHandler
    public void onAFKStop(AFKStopEvent e) {
        if (!getConfig().contains("AFKStop"))
            return;
        for (String command : getConfig().getStringList("AFKStop")) {
            runCommand(command, Bukkit.getPlayer(e.getPlayer().getUUID()));
        }
    }

    @EventHandler
    public void onAFKAction(AFKActionEvent e) {
        if (!getConfig().contains("AFKAction"))
            return;
        for (String command : getConfig().getStringList("AFKAction")) {
            runCommand(command, Bukkit.getPlayer(e.getPlayer().getUUID()));
        }
    }

    private void runCommand(String s, Player p) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s.replace("%PLAYER%", p.getName()));
    }

}
