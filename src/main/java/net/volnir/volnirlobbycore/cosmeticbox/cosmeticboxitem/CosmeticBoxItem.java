package net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

public class CosmeticBoxItem {
	public ItemStack cosmeticBoxItem(Player player) {
		ItemStack cosmeticBox = new ItemStack(Material.CHORUS_FLOWER);
		ItemMeta profileMeta =  cosmeticBox.getItemMeta();

		profileMeta.displayName(Component.text("Cosmetics", TextColor.fromHexString("#30D5C8")));

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "COSMETICS_PROFILE_ITEM");
		profileMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "COSMETIC_BOX_ITEM");

		cosmeticBox.setItemMeta(profileMeta);

		return cosmeticBox;
	}
}
