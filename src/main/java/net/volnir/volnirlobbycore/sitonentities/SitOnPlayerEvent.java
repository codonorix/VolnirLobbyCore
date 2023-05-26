package net.volnir.volnirlobbycore.sitonentities;

import net.kyori.adventure.text.Component;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import net.volnir.volnirlobbycore.helperclasses.PermissionMessage;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.List;

public class SitOnPlayerEvent implements Listener {
	@EventHandler
	public void playerSitOnPlayerEvent(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();

		if(!(player.hasPermission(Permission.ADMIN_PERMISSIONS.toString()))) {
			player.sendMessage(PermissionMessage.ADMIN_PERMISSIONS.message());
		}

		Entity entity = event.getRightClicked();
		List<Entity> playerTower = entity.getPassengers();

		if(playerTower.isEmpty()) {
			entity.addPassenger(player);
			return;
		}

		Entity lastPlayer = entity;

		while(true) {
			if(lastPlayer.getPassengers().isEmpty()) {
				lastPlayer.addPassenger(player);
				break;
			}

			lastPlayer = playerTower.get(0);
		}
	}
}
