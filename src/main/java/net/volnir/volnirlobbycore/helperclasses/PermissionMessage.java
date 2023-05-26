package net.volnir.volnirlobbycore.helperclasses;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

public enum PermissionMessage {

	ADMIN_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("ADMIN", TextColor.fromHexString("#e62ae6"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build()),
	APPRENTICE_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("APPRENTICE", TextColor.fromHexString("#870a87"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build()),
	SCHOLAR_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("SCHOLAR", TextColor.fromHexString("#b11eb1"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build()),
	ASCENDANT_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("ASCENDANT", TextColor.fromHexString("#d226d2"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build()),
	BUILDER_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("BUILDER", TextColor.fromHexString("#b897d3"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build()),
	DONATORONE_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("DONATORONE", TextColor.fromHexString("#fffb9c"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build()),
	DONATORTWO_PERMISSIONS(Component.text()
			.append(Component.text("You must have the ", TextColor.color(255, 0, 0)))
			.append(Component.text("DONATORTWO", TextColor.fromHexString("#fcde2b"), TextDecoration.BOLD))
			.append(Component.text(" to use this command!", TextColor.color(255, 0, 0)))
			.build())
	;

	private final TextComponent permission;

	private PermissionMessage(final TextComponent permission) {
		this.permission = permission;
	}

	public TextComponent message() {
		return permission;
	}
}
