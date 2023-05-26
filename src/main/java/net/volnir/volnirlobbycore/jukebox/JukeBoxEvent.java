package net.volnir.volnirlobbycore.jukebox;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import net.volnir.volnirlobbycore.helperclasses.PermissionMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Jukebox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;

public class JukeBoxEvent implements Listener {
	@EventHandler
	public void onJukeBoxClickEvent(PlayerInteractEvent event) {
		if(event.getClickedBlock() == null || !(event.getClickedBlock().getType() == Material.JUKEBOX) || !(event.getAction().isRightClick())) return;
		Player player = event.getPlayer();

		if(!player.hasPermission(Permission.DONATORONE_PERMISSIONS.toString())) {
			player.sendMessage(PermissionMessage.DONATORONE_PERMISSIONS.message());
			return;
		}

		player.openInventory(generateGUI());
	}

	private Inventory generateGUI() {
		Inventory inventory = new JukeBoxInventoryHolder(9*3, Component.text("Music Player",TextColor.color(50, 50, 50))).getInventory();

		ArrayList<ItemStack> itemStacks = getMusicDisc();

		for(int i = 0; i < 9; i++) {
			inventory.setItem(i, itemStacks.get(i));
		}

		inventory.setItem(10, itemStacks.get(9));
		inventory.setItem(11, itemStacks.get(10));
		inventory.setItem(12, itemStacks.get(11));

		inventory.setItem(14, itemStacks.get(12));
		inventory.setItem(15, itemStacks.get(13));
		inventory.setItem(16, itemStacks.get(14));

		inventory.setItem(22, itemStacks.get(15));

		return inventory;
	}

	private ArrayList<ItemStack> getMusicDisc() {
		ArrayList<ItemStack> discs = new ArrayList<>();

		discs.add(createDisc(Material.MUSIC_DISC_STRAD, Component.text("Strad", TextColor.color(255, 255, 255)), JukeBoxContainer.STRAD_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_MELLOHI, Component.text("Mellohi", TextColor.color(176, 0, 252)), JukeBoxContainer.MELLOHI_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_FAR, Component.text("Far", TextColor.color(128, 254, 199)), JukeBoxContainer.FAR_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_BLOCKS, Component.text("Blocks", TextColor.color(239, 169, 157)), JukeBoxContainer.BLOCKS_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_CHIRP, Component.text("Chirp", TextColor.color(254, 128, 130)), JukeBoxContainer.CHIRP_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_STAL, Component.text("Stal", TextColor.color(0, 0, 0)), JukeBoxContainer.STAL_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_WAIT, Component.text("Wait", TextColor.color(163, 185, 216)), JukeBoxContainer.WAIT_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_13, Component.text("13", TextColor.color(254, 234, 128)), JukeBoxContainer.THIRTEEN_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_OTHERSIDE, Component.text("Otherside", TextColor.color(175, 225, 162)), JukeBoxContainer.OTHERSIDED_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_CAT, Component.text("Cat", TextColor.color(165, 254, 128)), JukeBoxContainer.CAT_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_MALL, Component.text("Mall", TextColor.color(163, 128, 254)), JukeBoxContainer.MALL_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_5, Component.text("5", TextColor.color(128, 200, 201)), JukeBoxContainer.FIVE_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_PIGSTEP, Component.text("Pigstep", TextColor.color(230, 124, 21)), JukeBoxContainer.PIGSTEP_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_11, Component.text("11", TextColor.color(168, 168, 168)), JukeBoxContainer.ELEVEN_DISC.toString()));
		discs.add(createDisc(Material.MUSIC_DISC_WARD, Component.text("Ward", TextColor.color(0, 150, 0)), JukeBoxContainer.WARD_DISC.toString()));
		discs.add(createDisc(Material.REDSTONE_BLOCK, Component.text("Stop Music", TextColor.color(255, 0, 0)), "DISC_STOP"));

		return discs;
	}

	private ItemStack createDisc(Material material, TextComponent name, String container) {
		ItemStack disc = new ItemStack(material);
		ItemMeta discMeta = disc.getItemMeta();
		discMeta.displayName(name);
		discMeta.lore(Arrays.asList(Component.text("")));
		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "JUKEBOX_MENU");
		discMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, container);
		disc.setItemMeta(discMeta);

		return disc;
	}
}
