package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class FlameSpiral {
	public void flameSpiral() {
		new BukkitRunnable() {
			int range = 0;
			double height = 0.01;
			@Override
			public void run() {
				for (Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("FLAME_SPIRAL_PARTICLE"))) continue;

					Location location = player.getLocation();

					double radial = Math.toRadians(range);
					double x = Math.cos(radial);
					double z = Math.sin(radial);

					location.add(x, height, z);
					location.getWorld().spawnParticle(Particle.FLAME, location, 0);
					location.subtract(z, height, z);

					range += 10;
					height += 0.03;

					if(range > 360) range = 0;
					if(height >= 2) height = 0.01;
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 1);
	}
}
