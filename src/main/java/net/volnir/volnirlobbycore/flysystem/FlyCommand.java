package net.volnir.volnirlobbycore.flysystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import net.volnir.volnirlobbycore.helperclasses.PermissionMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		if(!(commandSender instanceof Player)) return false;
		Player player = (Player) commandSender;
		if(!(player.hasPermission(Permission.DONATORONE_PERMISSIONS.toString()))) {
			player.sendMessage(PermissionMessage.DONATORONE_PERMISSIONS.message());
			return false;
		}

		if(player.getAllowFlight()) {
			disableFlight(player);
		}else{
			enableFlight(player);
		}
		return false;
	}

	private void disableFlight(Player player) {
		player.setAllowFlight(false);
		player.setFlying(false);
		player.sendMessage(Component.text()
				.append(Component.text("Your flight has been disabled.", TextColor.color(255, 0, 0)))
				.build());
	}

	private void enableFlight(Player player) {
		player.setAllowFlight(true);
		player.setFlying(true);
		player.sendMessage(Component.text()
				.append(Component.text("Your flight has been enabled.", TextColor.color(0, 255, 0)))
				.build());
	}
}
