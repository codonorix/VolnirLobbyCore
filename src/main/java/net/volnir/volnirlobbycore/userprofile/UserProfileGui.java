package net.volnir.volnirlobbycore.userprofile;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.volnir.volnirlobbycore.helperclasses.InventoryItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class UserProfileGui {
	public Inventory userProfileGui(Player player) {
		String guiKey = "PLAYER_PROFILE";

		Inventory inventory = new UserProfileHolder(9, Component.text("User Profile", TextColor.fromHexString("#30D5C8"))).getInventory();
		inventory.setItem(2, new InventoryItemBuilder().normalItemBuilder(
				Material.NAME_TAG,
				Component.text("Information", TextColor.fromHexString("#30D5C8")),
				"PLAYER_INFO",
				Arrays.asList(
						Component.text("Rank: " + "N/A", TextColor.fromHexString("#30D5C8"))
				),
				guiKey
		));

		inventory.setItem(3, new InventoryItemBuilder().normalItemBuilder(
				Material.POTION,
				Component.text("Boosters", TextColor.fromHexString("#30D5C8")),
				"BOOSTERS",
				null,
				guiKey
		));

		inventory.setItem(5, new InventoryItemBuilder().normalItemBuilder(
				Material.DIAMOND,
				Component.text("Achievements", TextColor.fromHexString("#30D5C8")),
				"ACHIEVEMENTS",
				null,
				guiKey
		));

		inventory.setItem(6, new InventoryItemBuilder().normalItemBuilder(
				Material.POPPY,
				Component.text("Friends", TextColor.fromHexString("#30D5C8")),
				"FRIENDS",
				null,
				guiKey
		));

		return inventory;
	}
}
