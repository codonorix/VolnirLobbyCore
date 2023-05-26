package net.volnir.volnirlobbycore.cosmeticbox.banners;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class BannerList {
	final private static ArrayList<ItemStack> instance = new ArrayList<>();

	public static ArrayList<ItemStack> getInstance() {
		return instance;
	}

	public static void addBanner(ItemStack banner) {
		instance.add(banner);
	}
}
