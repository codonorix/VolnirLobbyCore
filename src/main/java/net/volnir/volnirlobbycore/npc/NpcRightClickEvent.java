package net.volnir.volnirlobbycore.npc;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class NpcRightClickEvent implements Listener {
	@EventHandler
	public void onNpcClickEvent(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		Entity entity = event.getRightClicked();
		if(!(entity.isCustomNameVisible())) return;
		if(!(event.getHand().equals(EquipmentSlot.HAND))) return;

		for(NpcCreation npcObject : NpcCreation.values()) {
			Component entityComponentName = npcObject.getEntity().getEntityComponentName();

			if(entityComponentName.equals(entity.customName())) {
				player.sendMessage(npcObject.getEntity().message());
				return;
			}
		}
	}

	@EventHandler
	public void onNpcHitEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player)) return;
		Player player = (Player) event.getDamager();
		Entity entity = event.getEntity();
		if(!(player.hasPermission(Permission.ADMIN_PERMISSIONS.toString()))) return;
		if(!entity.isCustomNameVisible()) return;

		for(NpcCreation npcObject : NpcCreation.values()) {
			Component entityComponentName = npcObject.getEntity().getEntityComponentName();

			if(entityComponentName.equals(entity.customName())) {
				entity.remove();
				player.sendMessage(Component.text("Custom NPC was removed.", TextColor.color(255, 0, 0)));
				return;
			}
		}
	}
}
