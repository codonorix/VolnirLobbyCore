package net.volnir.volnirlobbycore.spawn;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import net.volnir.volnirlobbycore.helperclasses.PermissionMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		if(!(commandSender instanceof Player)) return false;
		Player player = (Player) commandSender;

		if(!(player.hasPermission(Permission.ADMIN_PERMISSIONS.toString()))) {
			player.sendMessage(PermissionMessage.ADMIN_PERMISSIONS.message());
		}

		VolnirLobbyCore.getInstance().getConfig().set("SpawnLocation", player.getLocation());
		player.sendMessage(Component.text("Spawn location has been set.", TextColor.color(0, 255, 0)));
		VolnirLobbyCore.getInstance().saveConfig();
		return true;
	}
}
