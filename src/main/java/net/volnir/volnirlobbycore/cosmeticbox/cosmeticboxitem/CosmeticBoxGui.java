package net.volnir.volnirlobbycore.cosmeticbox.cosmeticboxitem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.helperclasses.InventoryItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class CosmeticBoxGui {
	public Inventory cosmeticBoxGui() {
		Inventory inventory = new CosmeticBoxHolder(2*9, Component.text("Cosmetics")).getInventory();

		inventory.setItem(3, new InventoryItemBuilder().normalItemBuilder(
				Material.BLACK_BANNER,
				Component.text("Banners", TextColor.color(0, 255, 170)),
				"BANNERS_COSMETIC_BUTTON",
				null,
				"COSMETICS_HOME"
		));

		inventory.setItem(4, new InventoryItemBuilder().normalItemBuilder(
				Material.LEAD,
				Component.text("Pets", TextColor.color(0, 255, 170)),
				"PETS_COSMETIC_BUTTON",
				null,
				"COSMETICS_HOME"
		));

		inventory.setItem(5, new InventoryItemBuilder().normalItemBuilder(
				Material.GLOW_BERRIES,
				Component.text("Particles", TextColor.color(0, 255, 170)),
				"PARTICLES_COSMETIC_BUTTON",
				null,
				"COSMETICS_HOME"
		));
		return inventory;
	}
}
