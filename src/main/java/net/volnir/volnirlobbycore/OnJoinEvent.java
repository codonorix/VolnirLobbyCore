package net.volnir.volnirlobbycore;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem.CosmeticBoxItem;
import net.volnir.volnirlobbycore.userprofile.UserProfileItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinEvent implements Listener {
	@EventHandler
	public void teleportToSpawnOnJoin(PlayerJoinEvent event) {
		event.getPlayer().teleport(VolnirLobbyCore.getSpawnLocation());
		event.getPlayer().getInventory().setItem(8, new UserProfileItem().userProfile(event.getPlayer()));
		event.getPlayer().getInventory().setItem(4, new CosmeticBoxItem().cosmeticBoxItem(event.getPlayer()));
		event.joinMessage();
	}
}
