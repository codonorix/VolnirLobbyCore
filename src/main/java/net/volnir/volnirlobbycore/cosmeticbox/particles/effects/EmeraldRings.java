package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class EmeraldRings {
	public void emeraldRings() {
		new BukkitRunnable() {
			int counter = 0;
			double tiltRadians = Math.toRadians(45);
			@Override
			public void run() {
				for(Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if(!(effect.equals("EMERALD_RINGS_PARTICLE"))) continue;
				double radian = Math.toRadians(counter);

				// Get the player's yaw (rotation around the Y-axis) and convert it to radians.
				// You might need to adjust this based on how Minecraft calculates yaw.
				// This assumes that the yaw is clockwise from the positive Z-axis.
				double yawRadians = Math.toRadians(player.getLocation().getYaw());

				double x = Math.cos(radian);
				double y = Math.sin(radian) * Math.sin(tiltRadians);
				double z = Math.sin(radian) * Math.cos(tiltRadians);

				// Rotate the coordinates based on the player's yaw
				double rotatedX = x * Math.cos(yawRadians) + z * Math.sin(yawRadians);
				double rotatedZ = -x * Math.sin(yawRadians) + z * Math.cos(yawRadians);

					Location location = player.getLocation();
					location.add(rotatedX, 1 + y, rotatedZ); // Add 1 to the y coordinate to center the ellipse on the player
					location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 0);
					location.subtract(rotatedX, 1 + y, rotatedZ);

					location.add(rotatedZ, 1 + y, rotatedX); // Add 1 to the y coordinate to center the ellipse on the player
					location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 0);
					location.subtract(rotatedZ, 1 + y, rotatedX);
				}

				counter += 5;

				if (counter > 360) {
					counter = 0;
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 3);
	}
}
