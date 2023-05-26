package net.volnir.volnirlobbycore.cosmeticbox.particles.gui;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.helperclasses.InventoryItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ParticlesGui {
	InventoryItemBuilder itemBuilder = new InventoryItemBuilder();
	final String GUI_KEY = "PARTICLES_MENU";
	final String KEY_END = "_PARTICLE";

	public Inventory particlesInventory() {
		Inventory inventory = new ParticlesHolder(9*3, Component.text("Particles")).getInventory();
		inventory.addItem(inLove());
		inventory.addItem(fromTheAshes());
		inventory.addItem(emeraldRings());
		inventory.addItem(shadowWalk());
		inventory.addItem(rainCloud());
		inventory.addItem(partyTime());
		inventory.addItem(flameSpiral());
		inventory.addItem(angel());

		inventory.setItem(22, removeParticle());

		return inventory;
	}

	private ItemStack inLove() {
		return itemBuilder.normalItemBuilder(
				Material.REDSTONE_BLOCK,
				Component.text("In Love", TextColor.color(200, 0, 0)),
				"IN_LOVE" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack fromTheAshes() {
		return itemBuilder.normalItemBuilder(
				Material.GUNPOWDER,
				Component.text("From The Ashes", TextColor.color(166, 166, 167)),
				"FROM_THE_ASHES" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack emeraldRings() {
		return itemBuilder.normalItemBuilder(
				Material.EMERALD,
				Component.text("Emerald Rings", TextColor.color(37, 234, 0)),
				"EMERALD_RINGS" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack shadowWalk() {
		return itemBuilder.normalItemBuilder(
				Material.OBSIDIAN,
				Component.text("Shadow Walk", TextColor.color(142, 144, 137)),
				"SHADOW_WALK" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack rainCloud() {
		return itemBuilder.normalItemBuilder(
				Material.WATER_BUCKET,
				Component.text("Rain Cloud", TextColor.color(0, 223, 238)),
				"RAIN_CLOUD" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack partyTime() {
		return itemBuilder.normalItemBuilder(
				Material.BLUE_STAINED_GLASS,
				Component.text("Party Time", TextColor.color(0, 223, 238)),
				"PARTY_TIME" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack flameSpiral() {
		return itemBuilder.normalItemBuilder(
				Material.FLINT_AND_STEEL,
				Component.text("Flame Spiral", TextColor.color(0, 223, 238)),
				"FLAME_SPIRAL" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack angel() {
		return itemBuilder.normalItemBuilder(
				Material.FEATHER,
				Component.text("Angel", TextColor.color(0, 223, 238)),
				"ANGEL" + KEY_END,
				null,
				GUI_KEY
		);
	}

	private ItemStack removeParticle() {
		return itemBuilder.normalItemBuilder(
				Material.REDSTONE_BLOCK,
				Component.text("Remove Particle", TextColor.color(0, 223, 238)),
				"STOP_ANIMATION",
				null,
				GUI_KEY
		);
	}
}
