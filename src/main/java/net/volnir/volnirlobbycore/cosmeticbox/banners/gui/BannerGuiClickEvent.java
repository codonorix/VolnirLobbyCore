package net.volnir.volnirlobbycore.cosmeticbox.banners.gui;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import net.volnir.volnirlobbycore.cosmeticbox.particles.gui.ParticlesHolder;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

public class BannerGuiClickEvent implements Listener {
	@EventHandler
	public void particleGuiClickEvent(InventoryClickEvent event) {
		if(event.getClickedInventory() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof BannersHolder)) return;

		event.setCancelled(true);

		if(event.getCurrentItem() == null) return;

		Player player = (Player) event.getWhoClicked();
		player.getEquipment().setHelmet(event.getCurrentItem());

		player.getInventory().close();
	}
}
