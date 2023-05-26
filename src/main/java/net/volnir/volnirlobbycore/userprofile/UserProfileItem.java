package net.volnir.volnirlobbycore.userprofile;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

public class UserProfileItem {
	public ItemStack userProfile(Player player) {
		ItemStack profileItem = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta profileMeta = (SkullMeta) profileItem.getItemMeta();

		profileMeta.displayName(Component.text("Player Profile", TextColor.fromHexString("#30D5C8")));
		profileMeta.setPlayerProfile(player.getPlayerProfile());

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "USER_PROFILE_ITEM");
		profileMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "PROFILE_SKULL_ITEM");

		profileItem.setItemMeta(profileMeta);

		return profileItem;
	}
}
