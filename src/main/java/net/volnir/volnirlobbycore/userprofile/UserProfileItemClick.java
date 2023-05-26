package net.volnir.volnirlobbycore.userprofile;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

public class UserProfileItemClick implements Listener {
	@EventHandler
	public void userProfileItemClick(PlayerInteractEvent event) {
		ItemStack itemStack = event.getItem();
		Player player = event.getPlayer();

		if(itemStack == null) return;

		ItemMeta itemMeta = itemStack.getItemMeta();
		PersistentDataContainer container = itemMeta.getPersistentDataContainer();
		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "USER_PROFILE_ITEM");

		if(!(container.has(key))) return;
		event.setCancelled(true);
		player.openInventory(new UserProfileGui().userProfileGui(player));
	}
}
