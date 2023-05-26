package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.cosmeticbox.particles.PlayerParticles;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class PartyTime {
	public void partyTime() {
		new BukkitRunnable() {
			int counter = 0;
			@Override
			public void run() {
				for (Map.Entry<Player, String> entry : PlayerParticles.getInstance().entrySet()) {
					Player player = entry.getKey();
					String effect = entry.getValue();

					if (!(effect.equals("PARTY_TIME_PARTICLE"))) continue;
					Location location = player.getLocation();

					double radian = Math.toRadians(counter);

					double x = Math.cos(radian);
					double z = Math.sin(radian);

					location.add(x, 2, z);

					location.getWorld().spawnParticle(Particle.BLOCK_CRACK, location, 1, 0, 0, 0, 0.1, Material.LIME_CONCRETE.createBlockData());
					location.getWorld().spawnParticle(Particle.BLOCK_CRACK, location, 1, 0, 0, 0, 0.1, Material.RED_CONCRETE.createBlockData());
					location.getWorld().spawnParticle(Particle.BLOCK_CRACK, location, 1, 0, 0, 0, 0.1, Material.PINK_CONCRETE.createBlockData());
					location.getWorld().spawnParticle(Particle.BLOCK_CRACK, location, 1, 0, 0, 0, 0.1, Material.ORANGE_CONCRETE.createBlockData());


					location.subtract(x, 0, z);

					counter += 10;

					if(counter > 360) counter = 0;
				}
			}
		}.runTaskTimer(VolnirLobbyCore.getInstance(), 0, 1);
	}
}
