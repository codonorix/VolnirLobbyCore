package net.volnir.volnirlobbycore.cosmeticbox.pet;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class PetGuiHolder implements InventoryHolder {
	private Inventory inventory;

	PetGuiHolder(int size, TextComponent title) {
		this.inventory = Bukkit.createInventory(this, size, title);
	}

	public Inventory getInventory() {
		return inventory;
	}
}
