package me.manglam.ecoplugin.listener;


import me.manglam.ecoplugin.data.EconomyDAO;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!EconomyDAO.playerExists(player.getUniqueId())) {
            EconomyDAO.createPlayer(player.getUniqueId());
        }
    }
}

