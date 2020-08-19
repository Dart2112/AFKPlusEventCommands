package net.lapismc.afkpluseventcommands;

import net.lapismc.afkplus.api.AFKActionEvent;
import net.lapismc.afkplus.api.AFKStartEvent;
import net.lapismc.afkplus.api.AFKStopEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AFKPlusEventCommands extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onAFKStart(AFKStartEvent e) {
        if (!getConfig().contains("AFKStart"))
            return;
        for (String command : getConfig().getStringList("AFKStart")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }

    @EventHandler
    public void onAFKStop(AFKStopEvent e) {
        if (!getConfig().contains("AFKStop"))
            return;
        for (String command : getConfig().getStringList("AFKStop")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }

    @EventHandler
    public void onAFKAction(AFKActionEvent e) {
        if (!getConfig().contains("AFKAction"))
            return;
        for (String command : getConfig().getStringList("AFKAction")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }

}
