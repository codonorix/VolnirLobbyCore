package net.volnir.volnirlobbycore.cosmeticbox.pet.pets;

import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.cosmeticbox.pet.PetObject;
import net.volnir.volnirlobbycore.npc.NpcObject;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public enum Pets {
	WADDLES_PET(new PetObject(
			EntityType.PIG,
			"Waddles",
			null,
			null,
			null,
			null,
			null,
			null,
			TextColor.color(255, 255, 0),
			new ItemStack(Material.SADDLE),
			"WADDLES_PET",
			false,
			false
	)),
	KING_JACK(new PetObject(
			EntityType.WITHER_SKELETON,
			"King Jack",
			Material.JACK_O_LANTERN,
			null,
			null,
			null,
			Material.EMERALD,
			null,
			TextColor.color(255, 70, 0),
			new ItemStack(Material.JACK_O_LANTERN),
			"KING_JACK_PET",
			false,
			false
	)),
	SOUL_ORB(new PetObject(
			EntityType.CREEPER,
			"Soul Orb",
			null,
			null,
			null,
			null,
			Material.EMERALD,
			null,
			TextColor.color(255, 70, 0),
			new ItemStack(Material.CRYING_OBSIDIAN),
			"SOUL_ORB_PET",
			true,
			false
	)),
	SEA_PICKLE_PET(new PetObject(
			EntityType.ZOMBIE,
			"Sea Pickle",
			Material.SEA_PICKLE,
			Material.SEA_PICKLE,
			Material.SEA_PICKLE,
			Material.SEA_PICKLE,
			Material.SEA_PICKLE,
			Material.SEA_PICKLE,
			TextColor.color(40, 70, 0),
			new ItemStack(Material.SEA_PICKLE),
			"SEA_PICKLE_PET",
			true,
			false
	)),
	NUGGET(new PetObject(
			EntityType.CHICKEN,
			"Nugget",
			Material.HAY_BLOCK,
			null,
			null,
			null,
			null,
			null,
			TextColor.color(244, 30, 123),
			new ItemStack(Material.FEATHER),
			"NUGGET_PET",
			false,
			false
	)),
	PUMPKLIN(new PetObject(
			EntityType.ZOMBIE,
			"Pumpklin Dumpling",
			Material.CARVED_PUMPKIN,
			null,
			null,
			null,
			null,
			null,
			TextColor.color(244, 30, 123),
			new ItemStack(Material.CARVED_PUMPKIN),
			"PUMPKLIN_PET",
			true,
			true
	)),
	GUARDIAN(new PetObject(
			EntityType.GUARDIAN,
			"Guardian",
			null,
			null,
			null,
			null,
			null,
			null,
			TextColor.color(244, 30, 123),
			new ItemStack(Material.SEA_LANTERN),
			"GUARDIAN_PET",
			false,
			false
	)),
	;

	private final PetObject npc;

	private Pets(final PetObject npcObject) {
		this.npc = npcObject;
	}

	public PetObject getEntity() {
		return npc;
	}
}
