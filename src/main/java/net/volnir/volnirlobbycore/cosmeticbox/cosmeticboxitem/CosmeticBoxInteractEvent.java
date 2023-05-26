package net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.banners.gui.BannersGui;
import net.volnir.volnirlobbycore.cosmeticbox.particles.gui.ParticlesGui;
import net.volnir.volnirlobbycore.cosmeticbox.pet.PetGui;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.persistence.PersistentDataType;

public class CosmeticBoxInteractEvent implements Listener {
	@EventHandler
	public void cosmeticBoxInteractEvent(InventoryClickEvent event) {
		if(event.getInventory().getHolder() == null) return;
		if(!(event.getInventory().getHolder() instanceof CosmeticBoxHolder)) return;
		event.setCancelled(true);
		if(event.getCurrentItem() == null) return;

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "COSMETICS_HOME");
		String data = event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING);
		if(data == null) return;
		Player player = (Player) event.getWhoClicked();

		if(data.equals("PETS_COSMETIC_BUTTON")) {
			player.openInventory(new PetGui().petGui());
		} else if (data.equals("PARTICLES_COSMETIC_BUTTON")) {
			player.openInventory(new ParticlesGui().particlesInventory());
		} else if (data.equals("BANNERS_COSMETIC_BUTTON")) {
			player.openInventory(new BannersGui().bannersInventory());
		}
	}
}
