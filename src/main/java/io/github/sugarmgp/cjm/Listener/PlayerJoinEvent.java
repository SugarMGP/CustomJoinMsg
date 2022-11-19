package io.github.sugarmgp.cjm.Listener;

import io.github.sugarmgp.cjm.CustomJoinMsg;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent e) {
        Player player = e.getPlayer();
        FileConfiguration config = CustomJoinMsg.getProvidingPlugin(CustomJoinMsg.class).getConfig();
        Boolean enable = config.getBoolean("enableJoinMsg");
        String message = config.getString("joinMessage");
        if (enable) {
            e.setJoinMessage(null);
            if (message != null) {
                Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(player, message));
            }
        }
    }
}