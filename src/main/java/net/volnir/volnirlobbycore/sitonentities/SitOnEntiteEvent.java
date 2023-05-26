package net.volnir.volnirlobbycore.sitonentities;

import net.volnir.volnirlobbycore.helperclasses.Permission;
import net.volnir.volnirlobbycore.helperclasses.PermissionMessage;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class SitOnEntiteEvent implements Listener {
	@EventHandler
	public void playerSitOnEntityEvent(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();

		if(!(player.hasPermission(Permission.ADMIN_PERMISSIONS.toString()))) {
			player.sendMessage(PermissionMessage.ADMIN_PERMISSIONS.message());
		}

		if(event.getRightClicked().getType() == EntityType.PARROT || event.getRightClicked().isCustomNameVisible() || event.getRightClicked().getType() == EntityType.PLAYER) return;

		event.getRightClicked().addPassenger(player);
	}
}
