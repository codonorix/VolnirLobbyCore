package net.volnir.volnirlobbycore.helperclasses;

import net.kyori.adventure.text.Component;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;

public class InventoryItemBuilder {
	public ItemStack normalItemBuilder(Material material, Component name, String itemKey, List<Component> lore, String guiKey) {
		ItemStack disc = new ItemStack(material);
		ItemMeta discMeta = disc.getItemMeta();
		discMeta.displayName(name);

		if(lore != null) {
			discMeta.lore(lore);
		}

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), guiKey);
		discMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, itemKey);
		disc.setItemMeta(discMeta);

		return disc;
	}
}
