package net.volnir.volnirlobbycore.helperclasses;

public enum Permission {
	ADMIN_PERMISSIONS("VOLNIR.PERMISSIONS.ADMIN"),
	APPRENTICE_PERMISSIONS("VOLNIR.PERMISSIONS.APPRENTICE"),
	SCHOLAR_PERMISSIONS("VOLNIR.PERMISSIONS.SCHOLAR"),
	ASCENDANT_PERMISSIONS("VOLNIR.PERMISSIONS.ASCENDANT"),
	BUILDER_PERMISSIONS("VOLNIR.PERMISSIONS.BUILDER"),
	DONATORONE_PERMISSIONS("VOLNIR.PERMISSIONS.DONATORONE"),
	DONATORTWO_PERMISSIONS("VOLNIR.PERMISSIONS.DONATORTWO")
	;

	private final String permission;

	private Permission(final String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return permission;
	}
}
