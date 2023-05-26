package net.volnir.volnirlobbycore.cosmeticbox.banners.gui;

import net.kyori.adventure.text.Component;
import net.volnir.volnirlobbycore.cosmeticbox.banners.designs.*;
import net.volnir.volnirlobbycore.cosmeticbox.particles.gui.ParticlesHolder;
import org.bukkit.inventory.Inventory;

public class BannersGui {
	public Inventory bannersInventory() {
		Inventory inventory = new BannersHolder(9*3, Component.text("Banners")).getInventory();

		inventory.addItem(new MatrixBanner().matrixBanner());
		inventory.addItem(new PrideBanner().prideBanner());
		inventory.addItem(new PugBanner().pugBanner()); //Plz fix
		inventory.addItem(new CatBanner().catBanner());
		inventory.addItem(new TheEyeBanner().theEyeBanner());

		return inventory;
	}
}
