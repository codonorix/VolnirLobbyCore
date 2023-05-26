package net.volnir.volnirlobbycore.cosmeticbox.banners.gui;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class BannersHolder implements InventoryHolder {
	private Inventory inventory;

	BannersHolder(int size, TextComponent title) {
		this.inventory = Bukkit.createInventory(this, size, title);
	}

	public Inventory getInventory() {
		return inventory;
	}
}
