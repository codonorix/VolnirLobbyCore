package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static java.lang.Math.sin;
import static org.joml.Math.cos;

public class FromTheAshes {
	public void coneEffect() {
		new BukkitRunnable() {
			double phi = 0;
			@Override
			public void run() {
				for(Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("FROM_THE_ASHES_PARTICLE"))) continue;

					phi += Math.PI / 16;
					double x;
					double y;
					double z;

					Location location = player.getLocation();

					for (double t = 0; t <= 2 * Math.PI; t += Math.PI / 16) {
						for (double i = 0; i <= 1; i += 1) {
							x = 0.3 * (2 * Math.PI - t) * 0.5 * cos(t + phi + i * Math.PI);
							y = 0.5 * t;
							z = 0.3 * (2 * Math.PI - t) * 0.5 * sin(t + phi + i * Math.PI);
							location.add(x, y, z);
							Bukkit.getWorld(player.getWorld().getUID()).spawnParticle(Particle.ASH, location, 1);
							location.subtract(x, y, z);
						}
					}
					if (phi > 10 * Math.PI) {
						phi = Math.PI / 16;
					}
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 2);

	}
}
