package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.Random;

public class RainCloud {
	Random random = new Random();
	public void rainCloud() {
		new BukkitRunnable() {
			@Override
			public void run() {
				for (Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("RAIN_CLOUD_PARTICLE"))) continue;
					Location location = player.getLocation();

					location.getWorld().spawnParticle(Particle.CLOUD, location.clone().add(0, 3, 0), 0);
					location.getWorld().spawnParticle(Particle.CLOUD, location.clone().add(.5, 3,0), 0);
					location.getWorld().spawnParticle(Particle.CLOUD, location.clone().add(0, 3,.5), 0);
					location.getWorld().spawnParticle(Particle.CLOUD, location.clone().add(-.5, 3, 0), 0);
					location.getWorld().spawnParticle(Particle.CLOUD, location.clone().add(0, 3, -.5), 0);

					for(int i = 0; i <= 3; i++) {
						double posOne = random.nextDouble() * 0.20 - 0.10;
						double posTwo = random.nextDouble() * 0.20 - 0.10;

						location.getWorld().spawnParticle(Particle.WATER_DROP, location.clone().add(posOne, 3, posTwo), 0);
					}
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 1);
	}
}
