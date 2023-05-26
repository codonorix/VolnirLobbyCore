package net.volnir.volnirlobbycore.cosmeticbox.pet;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.pet.pets.Pets;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PetGuiClick implements Listener {
	@EventHandler
	public void petGuiClickEvent(InventoryClickEvent event) {
		if(event.getClickedInventory() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof PetGuiHolder)) return;
		if(event.getCurrentItem() == null) return;
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "PETS_MENU");
		PersistentDataContainer container = event.getCurrentItem().getItemMeta().getPersistentDataContainer();
		String data = container.get(key, PersistentDataType.STRING);

		for(Pets pet : Pets.values()) {
			if(pet.getEntity().buildGuiItem().getItemMeta().getPersistentDataContainer().get(key,PersistentDataType.STRING).equals(data)) {
				if(PetContainer.getPlayerPets().containsKey(player)) clearPet(player);
				Mob mob = null;
				if(data.equals("SOUL_ORB_PET")) {
					mob = pet.getEntity().buildSoulOrb(player);
				}else {
					mob = pet.getEntity().buildEntity(player);
				}
				PetContainer.getPlayerPets().put(player, mob);
				return;
			}
		}
	}

	private void clearPet(Player player) {
		PetContainer.getPlayerPets().get(player).remove();
		PetContainer.getPlayerPets().remove(player);
	}
}
