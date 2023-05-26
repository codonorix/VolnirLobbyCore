package net.volnir.volnirlobbycore.userprofile;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class UserProfileHolder implements InventoryHolder {
	private Inventory inventory;

	UserProfileHolder(int size, TextComponent title) {
		this.inventory = Bukkit.createInventory(this, size, title);
	}

	public Inventory getInventory() {
		return inventory;
	}
}
