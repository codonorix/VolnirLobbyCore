package net.volnir.volnirlobbycore.npc;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import net.volnir.volnirlobbycore.helperclasses.PermissionMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NpcSpawnCommand implements CommandExecutor, TabCompleter {
	@Override
	public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		if(!(commandSender instanceof Player)) return false;

		Player player = (Player) commandSender;
		if(!(player.hasPermission(Permission.ADMIN_PERMISSIONS.toString()))) {
			player.sendMessage(PermissionMessage.ADMIN_PERMISSIONS.message());
			return false;
		}

		if(strings.length == 0) {
			player.sendMessage(Component.text("INVALID USAGE", TextColor.color(255, 0, 0), TextDecoration.BOLD));
			player.sendMessage(Component.text("/spawnnpc {npc_name}", TextColor.color(255, 0, 0)));
			return false;
		}

		for(NpcCreation npcObject : NpcCreation.values()) {
			if(npcObject.name().equals(strings[0])) {
				npcObject.getEntity().buildEntity(player);
				return true;
			}
		}
		player.sendMessage(Component.text("INVALID USAGE", TextColor.color(255, 0, 0), TextDecoration.BOLD));
		player.sendMessage(Component.text(("No Such NPC -> " + strings[0]), TextColor.color(255, 0, 0)));
		return false;
	}

	@Override
	public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
		List<String> completions = new ArrayList<>();

		for(NpcCreation npcObject : NpcCreation.values()) {
			completions.add(npcObject.name());
		}

		return completions;
	}
}
