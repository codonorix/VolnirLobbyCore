package net.volnir.volnirlobbycore.cosmeticbox.particles.effects;

import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public class Testing implements CommandExecutor {
	public void testing(Player player) {
		new BukkitRunnable() {
			@Override
			public void run() {

				//Drawing sphere
//				Location location = player.getEyeLocation();
//				double radius = 2;
//
//				for(double degree = 0; degree <= 360; degree+= 25) {
//					double radians = Math.toRadians(degree);
//					double x = Math.cos(radians) * radius;
//					double z = Math.sin(radians) * radius;
//
//					drawCircle(location, player, x, z);
//				}

				//Normal circle
//				for (int degree = 0; degree < 360; degree += 45) {
//					double radians = Math.toRadians(degree);
//
//					double x = Math.cos(radians) * 2;
//					double z = Math.sin(radians) * 2;
//
//					//Half circle
////					if(location.getY() + z < location.getY())
////						continue;
//
//					location.add(x, 0, z);
//					Bukkit.getWorld(player.getWorld().getUID()).spawnParticle(Particle.FLAME, location, 0);
//					location.subtract(x, 0, z);
//				}

				//==========================================
				//DRAWING VECTOR
				//==========================================
				Location location = player.getLocation().add(0, 1, 0);
				int length = 20; //show 20 blocks ahead

				for(int block = 1; block < length; block += 1) {
					Vector vector = location.getDirection().multiply(block);
					location.add(vector);
					location.getWorld().spawnParticle(Particle.DRIP_LAVA, location, 0);

					Block block1 = location.getBlock();

					if(!(block1.getType() == Material.AIR)) {
						location.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, location, 0);
					}
				}
			}
		}.runTaskTimerAsynchronously(VolnirLobbyCore.getInstance(), 0, 1);
	}

	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		testing((Player) commandSender);
		return false;
	}

	private void drawCircle(Location center, Player player, double height, double radius) {
		for(double degree = 0; degree <= 180; degree+= 25) {
			double radians = Math.toRadians(degree);
			double x = Math.cos(radians) * radius;
			double z = Math.sin(radians) * radius;

			center.add(x, height, z);
			Bukkit.getWorld(player.getWorld().getUID()).spawnParticle(Particle.FLAME, center, 0);
			center.subtract(x, height, z);
		}
	}
}
