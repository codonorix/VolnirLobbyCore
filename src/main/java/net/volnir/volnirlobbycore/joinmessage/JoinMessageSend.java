package net.volnir.volnirlobbycore.joinmessage;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.volnir.volnirlobbycore.helperclasses.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessageSend implements Listener {
	private TextColor white = TextColor.color(255, 255, 255);
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if(player.hasPermission(Permission.ADMIN_PERMISSIONS.toString())) {
			event.joinMessage(adminJoinMessage(player));
		} else if (player.hasPermission(Permission.ASCENDANT_PERMISSIONS.toString())) {
			event.joinMessage(ascendantJoinMessage(player));
		} else if (player.hasPermission(Permission.SCHOLAR_PERMISSIONS.toString())) {
			event.joinMessage(scholarJoinMessage(player));
		} else if (player.hasPermission(Permission.APPRENTICE_PERMISSIONS.toString())) {
			event.joinMessage(apprenticeJoinMessage(player));
		} else if (player.hasPermission(Permission.BUILDER_PERMISSIONS.toString())) {
			event.joinMessage(builderJoinMessage(player));
		} else if (player.hasPermission(Permission.DONATORONE_PERMISSIONS.toString())) {
			event.joinMessage(donorOneJoinMessage(player));
		} else if (player.hasPermission(Permission.DONATORTWO_PERMISSIONS.toString())) {
			event.joinMessage(donorTwoJoinMessage(player));
		} else {
			event.joinMessage(defaultJoinMessage(player));
		}

//		player.sendMessage(defaultJoinMessage(player));
	}

	private TextComponent adminJoinMessage(Player player) {
		TextColor purpleColor = TextColor.fromHexString("#e62ae6");

		return Component.text()
				.append(Component.text("★ ", purpleColor))
				.append(Component.text(" You are in the presence of ", purpleColor))
				.append(Component.text("ADMIN ", purpleColor, TextDecoration.BOLD))
				.append(player.displayName().color(purpleColor))
				.append(Component.text(" ★", purpleColor))
				.build();
	}

	private TextComponent apprenticeJoinMessage(Player player) {
		TextColor greenColor = TextColor.fromHexString("#870a87");

		return Component.text()
				.append(Component.text("✧ ", greenColor))
				.append(Component.text("APPRENTICE ", greenColor, TextDecoration.BOLD))
				.append(player.displayName().color(greenColor))
				.append(Component.text(" is here to help", greenColor))
				.append(Component.text(" ✧", greenColor))
				.build();
	}

	private TextComponent scholarJoinMessage(Player player) {
		TextColor color = TextColor.fromHexString("#b11eb1");

		return Component.text()
				.append(Component.text("✦ ", color))
				.append(Component.text("SCHOLAR ", color, TextDecoration.BOLD))
				.append(player.displayName().color(color))
				.append(Component.text(" is reporting for duty", color))
				.append(Component.text(" ✦", color))
				.build();
	}

	private TextComponent ascendantJoinMessage(Player player) {
		TextColor color = TextColor.fromHexString("#d226d2");

		return Component.text()
				.append(Component.text("☆ ", color))
				.append(Component.text("Trusted advisor ", color))
				.append(Component.text("ASCENDANT ", color, TextDecoration.BOLD))
				.append(player.displayName().color(color))
				.append(Component.text(" is in", color))
				.append(Component.text(" ☆", color))
				.build();
	}

	private TextComponent builderJoinMessage(Player player) {
		TextColor color = TextColor.fromHexString("#b897d3");

		return Component.text()
				.append(Component.text("⟰ ", color))
				.append(Component.text("Timberrr! ", color))
				.append(Component.text("BUILDER ", color, TextDecoration.BOLD))
				.append(player.displayName().color(color))
				.append(Component.text(" is here!", color))
				.append(Component.text(" ⟰", color))
				.build();
	}

	private TextComponent donorOneJoinMessage(Player player) {
		TextColor color = TextColor.fromHexString("#fffb9c");

		return Component.text()
				.append(Component.text("〈 ", color))
				.append(Component.text("RANK1 ", color, TextDecoration.BOLD))
				.append(player.displayName().color(color))
				.append(Component.text(" has arrived", color))
				.append(Component.text(" 〉", color))
				.build();
	}

	private TextComponent donorTwoJoinMessage(Player player) {
		TextColor color = TextColor.fromHexString("#fcde2b");

		return Component.text()
				.append(Component.text("《 ", color))
				.append(Component.text("RANK2 ", color, TextDecoration.BOLD))
				.append(player.displayName().color(color))
				.append(Component.text(" has arrived", color))
				.append(Component.text(" 》", color))
				.build();
	}

	private TextComponent defaultJoinMessage(Player player) {
		TextColor color = TextColor.fromHexString("#676E6A");

		return Component.text()
				.append(player.displayName().color(color))
				.append(Component.text(" joined the game.", color))
				.build();
	}
}
