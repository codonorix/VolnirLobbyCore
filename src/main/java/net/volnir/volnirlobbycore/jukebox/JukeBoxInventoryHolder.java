package net.volnir.volnirlobbycore.jukebox;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class JukeBoxInventoryHolder implements InventoryHolder {
	private Inventory inventory;

	JukeBoxInventoryHolder(int size, TextComponent title) {
		this.inventory = Bukkit.createInventory(this, size, title);
	}

	public Inventory getInventory() {
		return inventory;
	}
}
