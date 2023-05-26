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

public class InLove {
	public void inLove() {
		final int[] radius = {0};

		new BukkitRunnable() {

			@Override
			public void run() {
				for(Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("IN_LOVE_PARTICLE"))) continue;
					if (radius[0] > 360) radius[0] = 0;
					double radians = Math.toRadians(radius[0]);
					double x = Math.cos(radians) * 0.5;
					double z = Math.sin(radians) * 0.5;

					Location location = player.getLocation();

					location.add(x, 2, z);
					player.getWorld().spawnParticle(Particle.HEART, location, 0);
					location.subtract(x, 2, z);

					radius[0] += 25;
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 5);
	}
}
