package net.volnir.volnirlobbycore.cosmeticbox.pet;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.volnir.volnirlobbycore.VolnirLobbyCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class PetObject {
	private EntityType entityType;
	private String  name;
	private Material headItem;
	private Material bodyItem;
	private Material legItem;
	private Material bootItem;
	private Material handItem;
	private Material handItemTwo;
	private TextColor textColor;
	private ItemStack displayIcon;
	private String cosmeticKey;
	private boolean isInvis;
	private boolean baby;


	public PetObject(EntityType entityType, String name, Material headItem, Material bodyItem, Material legItem, Material bootItem, Material handItem, Material handItemTwo, TextColor textColor, ItemStack displayIcon, String cosmeticKey, boolean isInvis, boolean baby) {
		this.entityType = entityType;
		this.name = name;
		this.headItem = headItem;
		this.bodyItem = bodyItem;
		this.legItem = legItem;
		this.bootItem = bootItem;
		this.handItem = handItem;
		this.handItemTwo = handItemTwo;
		this.textColor = textColor;
		this.displayIcon = displayIcon;
		this.cosmeticKey = cosmeticKey;
		this.isInvis = isInvis;
		this.baby = baby;
	}

	public Mob buildEntity(Player player) {
		Mob pet = (Mob) player.getWorld().spawnEntity(player.getLocation(), entityType);

		pet.customName(
				player.displayName().color(textColor)
						.append(Component.text(("'s " + name + " pet"), textColor))
		);
		pet.setCustomNameVisible(true);
		pet.setInvulnerable(true);

		if(baby) {
			((Zombie) pet).setBaby();
		}

		if(headItem != null) pet.getEquipment().setHelmet(new ItemStack(headItem));
		if(bodyItem != null) pet.getEquipment().setChestplate(new ItemStack(bodyItem));
		if(legItem != null) pet.getEquipment().setLeggings(new ItemStack(legItem));
		if(bootItem != null) pet.getEquipment().setBoots(new ItemStack(bootItem));
		if(handItem != null) pet.getEquipment().setItemInMainHand(new ItemStack(handItem));
		if(handItemTwo != null) pet.getEquipment().setItemInOffHand(new ItemStack(handItemTwo));
		pet.setInvisible(isInvis);


		Bukkit.getMobGoals().removeAllGoals(pet);
		Bukkit.getMobGoals().addGoal(pet, 0, new PetGoal(pet, player));

		return pet;
	}

	public Mob buildSoulOrb(Player player) {
		Creeper pet = (Creeper) player.getWorld().spawnEntity(player.getLocation(), entityType);

		pet.customName(
				player.displayName().color(textColor)
						.append(Component.text(("'s " + name + " pet"), textColor))
		);
		pet.setCustomNameVisible(true);
		pet.setInvulnerable(true);
		pet.setPowered(true);
		pet.setInvisible(true);
		pet.setExplosionRadius(0);

		Bukkit.getMobGoals().removeAllGoals(pet);
		Bukkit.getMobGoals().addGoal(pet, 0, new PetGoal(pet, player));

		return pet;
	}

	public ItemStack buildGuiItem() {
		ItemStack itemStack = new ItemStack(displayIcon);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.displayName(Component.text(name, textColor));

		NamespacedKey key = new NamespacedKey(VolnirLobbyCore.getInstance(), "PETS_MENU");
		itemMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, cosmeticKey);

		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Material getHeadItem() {
		return headItem;
	}

	public void setHeadItem(Material headItem) {
		this.headItem = headItem;
	}

	public Material getBodyItem() {
		return bodyItem;
	}

	public void setBodyItem(Material bodyItem) {
		this.bodyItem = bodyItem;
	}

	public Material getLegItem() {
		return legItem;
	}

	public void setLegItem(Material legItem) {
		this.legItem = legItem;
	}

	public Material getBootItem() {
		return bootItem;
	}

	public void setBootItem(Material bootItem) {
		this.bootItem = bootItem;
	}

	public Material getHandItem() {
		return handItem;
	}

	public void setHandItem(Material handItem) {
		this.handItem = handItem;
	}

	public Material getHandItemTwo() {
		return handItemTwo;
	}

	public void setHandItemTwo(Material handItemTwo) {
		this.handItemTwo = handItemTwo;
	}

	public TextColor getTextColor() {
		return textColor;
	}

	public void setTextColor(TextColor textColor) {
		this.textColor = textColor;
	}

	public ItemStack getDisplayIcon() {
		return displayIcon;
	}

	public void setDisplayIcon(ItemStack displayIcon) {
		this.displayIcon = displayIcon;
	}
}
