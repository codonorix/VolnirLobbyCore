package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class ShadowWalk {
	public void shadowWalk() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for(Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("SHADOW_WALK_PARTICLE"))) continue;

					Location location = player.getLocation().add(-.2,.3,0);

					location.getWorld().spawnParticle(Particle.SMOKE_NORMAL, location, 0);
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 1);
	}
}
