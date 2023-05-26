package net.volnir.volnirlobbycore.cosmeticbox.pet;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PetContainer {
	private static HashMap<Player, Entity> playerPets = null;

	public static HashMap<Player, Entity> getPlayerPets() {
		if (playerPets == null) playerPets = new HashMap<>();

		return playerPets;
	}
}
