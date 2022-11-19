package io.github.sugarmgp.Listener;

import io.github.sugarmgp.CustomJoinMsg;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {
    @EventHandler
    public void onPlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent e) {
        Player player = e.getPlayer();
        FileConfiguration config = CustomJoinMsg.getProvidingPlugin(CustomJoinMsg.class).getConfig();
        Boolean enable = config.getBoolean("enableQuitMsg");
        String message = config.getString("quitMessage");
        if (enable) {
            e.setQuitMessage(null);
            if (message != null) {
                Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(player, message));
            }
        }
    }
}