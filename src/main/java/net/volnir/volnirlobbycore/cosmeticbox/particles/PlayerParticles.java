package net.volnir.volnirlobbycore.cosmeticbox.particles;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerParticles {
	final private static HashMap<Player, String> instance = new HashMap<>();

	public static HashMap<Player, String> getInstance() {
		return instance;
	}

	public static void addUser(Player player, String effect) {
		instance.put(player, effect);
	}

	public static void removeUser(Player player) {
		instance.remove(player);
	}
}
