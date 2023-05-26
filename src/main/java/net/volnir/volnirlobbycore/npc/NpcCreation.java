package net.volnir.volnirlobbycore.npc;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public enum NpcCreation {
	XARIEL_ARCANA(new NpcObject(
			EntityType.ILLUSIONER,
			TextColor.color(0, 0, 59),
			"Xariel's Arcana",
			Arrays.asList(
					"Many a thing can be found in the forgotten places of the world.",
					"Great power sometimes resides in that which appears ordinary.",
					"To unlock true Magick the mind must be still.",
					"In these ancient scrolls are contained a universe of knowledge.",
					"The key to unlock the greatest Arcana of them all is the mind.",
					"Be wary lest you find what you seek."
			),
			null,
			null,
			null,
			null,
			new ItemStack(Material.AMETHYST_CLUSTER),
			null
	)),
	WADDLES(new NpcObject(
			EntityType.PIG,
			TextColor.color(0, 200, 200),
			"Waddles",
			Arrays.asList(
					"Oink Oink Oink.",
					"Oinkity oink! I'm Waddles!",
					"Oink oink oink oink!",
					"Oink oink oink oink oink, oink oink!",
					"Oink oink oink oinkity oink!",
					"Oink oink oinkity oink oink oink oink!",
					"Oink oink oink oinkity oink oink oink oink oink oink oink oink!",
					"OINK OINK OINK!",
					"Oinkity oink! OINK OINK OINK!",
					"Oink oink OINK oink!",
					"OINK oink oink OINK oink oink!",
					"Oinkity OINK oink oinkity oink!",
					"Oink oink oinkity oink oink OINK OINK!",
					"OINK OINK OINK OINKITY OINK OINK OINK OINK!",
					"Oink oink oink OINKITY oink oink oink oink oink oink oink OINK OINK!",
					"Greetings, friends. It is I, Waddles the pig.",
					"Forgive me, my pig arms are cute and useless."
			),
			null,
			null,
			null,
			null,
			null,
			null
	)),
	MERLIN_COSMETICS(new NpcObject(
			EntityType.DROWNED,
			TextColor.color(0, 200, 200),
			"Merlin",
			Arrays.asList(
					"Cosmetics are like magic.",
					"The number of things I've seen during my travels are nothing compared to Xariel",
					"Everyone loves waddles... that is until he randomly speaks English..."
			),
			new ItemStack(Material.CYAN_STAINED_GLASS),
			new ItemStack(Material.DIAMOND_CHESTPLATE),
			new ItemStack(Material.DIAMOND_LEGGINGS),
			new ItemStack(Material.DIAMOND_BOOTS),
			new ItemStack(Material.TURTLE_EGG),
			null
	)),
	AXOLOTL_FLOWER(new NpcObject(
			EntityType.AXOLOTL,
			TextColor.color(200, 0, 110),
			"Flower Cashier",
			Arrays.asList(
					"You can't ever have too many flowers!",
					"The owner of this shop would make a good villain against batman. Poison Ivy is so cool!",
					"This is the most magical shop in town square!"
			),
			null,
			null,
			null,
			null,
			null,
			null
	)),
	TIMS_SERVANT(new NpcObject(
			EntityType.VILLAGER,
			TextColor.color(200, 3, 0),
			"Tims Servant",
			Arrays.asList(
					"Pain... all I feel is pain...",
					"...",
					"...",
					"Please... help...",
					"Sorry! We don't sell books! They are all for Tim!",
					"ȺȺȺȺȺȺȺȺȺȺȺȺȺȺȺȺȺȺ"
			),
			new ItemStack(Material.BOOKSHELF),
			null,
			null,
			null,
			null,
			null
	)),
	;

	private final NpcObject npc;

	private NpcCreation(final NpcObject npcObject) {
		this.npc = npcObject;
	}

	public NpcObject getEntity() {
		return npc;
	}
}
