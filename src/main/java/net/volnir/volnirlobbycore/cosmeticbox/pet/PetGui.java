package net.volnir.volnirlobbycore.cosmeticbox.pet;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.pet.pets.Pets;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PetGui {
	public Inventory petGui() {
		Inventory inventory = new PetGuiHolder(9*3, Component.text("Pets", TextColor.color(0, 255, 0), TextDecoration.BOLD)).getInventory();

		for(Pets petObject : Pets.values()) {
			inventory.addItem(petObject.getEntity().buildGuiItem());
		}

		return inventory;
	}

	private ItemStack petIcon(Material material, Component name, String dataName) {
		ItemStack itemStack = new ItemStack(material);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.displayName(name);
		NamespacedKey namespacedKey = new NamespacedKey(VolnirLobbyCore.getInstance(), "PETS_MENU_ITEM");
		itemMeta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, dataName);
		itemStack.setItemMeta(itemMeta);

		return itemStack;
	}
}
