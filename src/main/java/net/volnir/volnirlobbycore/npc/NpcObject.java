package net.volnir.volnirlobbycore.npc;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NpcObject {
	private EntityType entityType;
	private TextColor textColor;
	private String name;
	private List<String> messages;
	private ItemStack headItem;
	private ItemStack bodyItem;
	private ItemStack pantsItem;
	private ItemStack bootItems;
	private ItemStack handOne;
	private ItemStack handTwo;

	public NpcObject(EntityType entityType, TextColor textColor, String name, List<String> messages, ItemStack headItem, ItemStack bodyItem, ItemStack pantsItem, ItemStack bootItems, ItemStack handOne, ItemStack handTwo) {
		this.entityType = entityType;
		this.textColor = textColor;
		this.name = name;
		this.messages = messages;
		this.headItem = headItem;
		this.bodyItem = bodyItem;
		this.pantsItem = pantsItem;
		this.bootItems = bootItems;
		this.handOne = handOne;
		this.handTwo = handTwo;
	}

	public void buildEntity(Player player) {
		 LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), entityType);
		 entity.setAI(false);
		 entity.customName(Component.text(name, textColor));
		 entity.setCustomNameVisible(true);
		 entity.setInvulnerable(true);

		 if(headItem != null) {
			 entity.getEquipment().setHelmet(headItem);
		 }

		 if(bodyItem != null) entity.getEquipment().setChestplate(bodyItem);
		 if(pantsItem != null) entity.getEquipment().setLeggings(pantsItem);
		 if(bootItems != null) entity.getEquipment().setBoots(bootItems);
		 if(handOne != null) entity.getEquipment().setItemInMainHand(handOne);
		 if(handTwo != null) entity.getEquipment().setItemInOffHand(handTwo);

	}

	public Component message() {
		Random random = new Random();
		String message = messages.get(random.nextInt(messages.size()));

		return Component.text()
				.append(Component.text(name + ": ", textColor, TextDecoration.BOLD))
				.append(Component.text(message, TextColor.color(255, 255, 255)))
				.build();
	}

	public Component getEntityComponentName() {
		return Component.text(name, textColor);
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public TextColor getTextColor() {
		return textColor;
	}

	public void setTextColor(TextColor textColor) {
		this.textColor = textColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public ItemStack getHeadItem() {
		return headItem;
	}

	public void setHeadItem(ItemStack headItem) {
		this.headItem = headItem;
	}

	public ItemStack getBodyItem() {
		return bodyItem;
	}

	public void setBodyItem(ItemStack bodyItem) {
		this.bodyItem = bodyItem;
	}

	public ItemStack getPantsItem() {
		return pantsItem;
	}

	public void setPantsItem(ItemStack pantsItem) {
		this.pantsItem = pantsItem;
	}

	public ItemStack getBootItems() {
		return bootItems;
	}

	public void setBootItems(ItemStack bootItems) {
		this.bootItems = bootItems;
	}

	public ItemStack getHandOne() {
		return handOne;
	}

	public void setHandOne(ItemStack handOne) {
		this.handOne = handOne;
	}

	public ItemStack getHandTwo() {
		return handTwo;
	}

	public void setHandTwo(ItemStack handTwo) {
		this.handTwo = handTwo;
	}
}
