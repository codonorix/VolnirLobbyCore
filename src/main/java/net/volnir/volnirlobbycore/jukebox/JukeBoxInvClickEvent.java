package net.volnir.volnirlobbycore.jukebox;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class JukeBoxInvClickEvent implements Listener {
	@EventHandler
	public void jukeBoxInvClickEvent(InventoryClickEvent event) {
		if(event.getClickedInventory() == null) return;
		if(!(event.getClickedInventory().getHolder() instanceof JukeBoxInventoryHolder)) return;
		if(event.getCurrentItem() == null) return;
		event.setCancelled(true);
		Player player = (Player) event.getWhoClicked();

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "JUKEBOX_MENU");
		PersistentDataContainer container = event.getCurrentItem().getItemMeta().getPersistentDataContainer();
		String data = container.get(key, PersistentDataType.STRING);

		player.stopAllSounds();
		int soundV = 5;
		int soundV2 = 1;

		if(data.equals(JukeBoxContainer.STRAD_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_STRAD, soundV, soundV2);
		} else if (data.equals(JukeBoxContainer.MELLOHI_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_MELLOHI, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.FAR_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_FAR, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.BLOCKS_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_MELLOHI, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.CHIRP_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_CHIRP, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.STAL_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_STAL, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.WAIT_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_WAIT, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.THIRTEEN_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_13, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.OTHERSIDED_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_OTHERSIDE, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.CAT_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_CAT, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.MALL_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_MALL, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.FIVE_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_5, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.PIGSTEP_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_PIGSTEP, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.ELEVEN_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_11, soundV, soundV2);
		}else if (data.equals(JukeBoxContainer.WARD_DISC.toString())) {
			player.playSound(player.getLocation(), Sound.MUSIC_DISC_WARD, soundV, soundV2);
		} else if (data.equals("DISC_STOP")) {
			player.stopAllSounds();
		}
	}
}
