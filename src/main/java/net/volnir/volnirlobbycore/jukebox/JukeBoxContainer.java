package net.volnir.volnirlobbycore.jukebox;

public enum JukeBoxContainer {
	STRAD_DISC("STRAD_DISC"),
	MELLOHI_DISC("MELLOHI_DISC"),
	FAR_DISC("FAR_DISC"),
	BLOCKS_DISC("BLOCKS_DISC"),
	CHIRP_DISC("CHIRP_DISC"),
	STAL_DISC("STAL_DISC"),
	WAIT_DISC("WAIT_DISC"),
	THIRTEEN_DISC("13_DISC"),
	OTHERSIDED_DISC("OTHERSIDED_DISC"),
	CAT_DISC("CAT_DISC"),
	MALL_DISC("MALL_DISC"),
	FIVE_DISC("5_DISC"),
	PIGSTEP_DISC("PIGSTEP_DISC"),
	ELEVEN_DISC("11_DISC"),
	WARD_DISC("WARD_DISC"),
			;

	private final String permission;

	private JukeBoxContainer(final String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return permission;
	}
}
