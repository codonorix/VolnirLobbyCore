package net.volnir.volnirlobbycore.cosmeticbox.particles.gui;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class ParticleGuiClickEvent implements Listener {
	final String GUI_KEY = "PARTICLES_MENU";
	final String KEY_END = "_PARTICLE";



	@EventHandler
	public void particleGuiClickEvent(InventoryClickEvent event) {
		if(event.getClickedInventory() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof ParticlesHolder)) return;

		event.setCancelled(true);

		if(event.getCurrentItem() == null) return;

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), GUI_KEY);
		String data = event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING);
		Player player = (Player) event.getWhoClicked();

		if(data.contains(KEY_END)) {
			PlayerParticles.addUser(player, data);
			player.sendMessage("Applied effect.");
		} else if (data.equals("STOP_ANIMATION")) {
			PlayerParticles.removeUser(player);
			player.sendMessage("Removed Particle");
		}

		player.getInventory().close();
	}
}
