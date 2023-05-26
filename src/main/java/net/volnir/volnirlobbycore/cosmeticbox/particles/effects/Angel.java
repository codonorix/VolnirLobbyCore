package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Angel {
	public void angel() {
		new BukkitRunnable() {
			//0 - no particle
			//1 - Blue particle
			//2 - White
			int[][] shape = {
					{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
					{0, 1, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 1, 0},
					{0, 1, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 1, 0},
					{0, 1, 2, 2, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 0},
					{0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 1, 0},
					{1, 1, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1},
					{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
					{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
					{0, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1, 0},
					{0, 0, 1, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 0, 0},
					{0, 1, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 0},
					{0, 0, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 0, 0},
					{0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 0, 0, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 1, 0, 0, 0, 0, 1, 2, 2, 2, 2, 0, 1, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
			};

			@Override
			public void run() {
				Particle.DustOptions yellow = new Particle.DustOptions(Color.YELLOW, 1);
				Particle.DustOptions white = new Particle.DustOptions(Color.WHITE, 1);
				Particle.DustOptions gold = new Particle.DustOptions(Color.ORANGE, 1);

				for (Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("ANGEL_PARTICLE"))) continue;

					Location location = player.getLocation();
					double height = 2;

					float yaw = location.getYaw();
					double yawRadians = Math.toRadians(yaw + 90);

					double xOffset = -1.5 * -Math.sin(yawRadians);
					double zOffset = -1.5 * Math.cos(yawRadians);

					for (int i = 0; i < shape.length; i++) {
						double particleLength = -1.3;
						for (int j = 0; j < shape[i].length; j++) {
							int particleShade = shape[i][j];
							switch (particleShade) {
								case 1:
									location.getWorld().spawnParticle(Particle.REDSTONE, location.clone().add(xOffset * particleLength, height, zOffset * particleLength), 0, yellow);
									break;
								case 2:
									location.getWorld().spawnParticle(Particle.REDSTONE, location.clone().add(xOffset * particleLength, height, zOffset * particleLength), 0, white);
									break;
							}
							particleLength += .1;
						}
						height -= .1;
					}

					for(int i = 0; i < 360; i += 25) {
						Location eyeLevel = player.getEyeLocation();
						double radial = Math.toRadians(i);
						double x = Math.cos(radial) * 0.5;
						double z = Math.sin(radial) * 0.5;

						eyeLevel.getWorld().spawnParticle(Particle.REDSTONE, eyeLevel.clone().add(x, .5, z), 0, gold);
					}
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 14);
	}
}
