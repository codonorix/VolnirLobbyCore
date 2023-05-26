package net.volnir.volnirlobbycore.cosmeticbox.pet.pets;

import net.volnir.volnirlobbycore.cosmeticbox.pet.PetContainer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class RemovePetOnLeave implements Listener {
	@EventHandler
	public void removePetOnLeave(PlayerQuitEvent event) {
		if(PetContainer.getPlayerPets().containsKey(event.getPlayer())) {
			PetContainer.getPlayerPets().get(event.getPlayer()).remove();
			PetContainer.getPlayerPets().remove(event.getPlayer());
		}
	}
}
