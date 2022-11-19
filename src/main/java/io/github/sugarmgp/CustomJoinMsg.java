package io.github.sugarmgp;

import io.github.sugarmgp.Command.MainCommand;
import io.github.sugarmgp.Listener.PlayerJoinEvent;
import io.github.sugarmgp.Listener.PlayerQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomJoinMsg extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("customjoinmsg").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent(), this);
    }
}
