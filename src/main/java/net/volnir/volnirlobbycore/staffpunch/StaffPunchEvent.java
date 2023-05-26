package net.volnir.volnirlobbycore.staffpunch;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.Vector;

public class StaffPunchEvent implements Listener {
	@EventHandler
	public void staffPunchEvent(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) return;

		Player donator = (Player) event.getDamager();
		Player staffMember = (Player) event.getEntity();

		if(!(donator.hasPermission(Permission.DONATORTWO_PERMISSIONS.toString())) || !(staffMember.hasPermission(Permission.APPRENTICE_PERMISSIONS.toString()))) return;

		event.setCancelled(true);
		Vector velocity = staffMember.getVelocity();
		velocity.setY(3);

		Bukkit.getWorld(staffMember.getWorld().getUID()).spawnParticle(Particle.EXPLOSION_NORMAL, staffMember.getLocation(),3);
		Bukkit.getWorld(staffMember.getWorld().getUID()).playSound(staffMember.getLocation(), Sound.ENTITY_GENERIC_EXPLODE,1,1);
		staffMember.setVelocity(velocity);

		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
			player.sendMessage(
					Component.text()
							.append(donator.displayName())
							.append(Component.text(" Just launched ", TextColor.fromHexString("#ffffff")))
							.append(staffMember.displayName())
							.append(Component.text(" into space!", TextColor.fromHexString("#ffffff")))
							.build());
		}
	}
}
