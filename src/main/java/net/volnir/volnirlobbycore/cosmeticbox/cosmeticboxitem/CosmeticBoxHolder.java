package net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class CosmeticBoxHolder implements InventoryHolder {
	private Inventory inventory;

	CosmeticBoxHolder(int size, TextComponent title) {
		this.inventory = Bukkit.createInventory(this, size, title);
	}

	public Inventory getInventory() {
		return inventory;
	}
}
