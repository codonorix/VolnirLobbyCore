package net.volnir.volnirlobbycore.cosmeticbox.banners.designs;

import net.kyori.adventure.text.Component;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class PrideBanner {
	public ItemStack prideBanner() {
		ItemStack banner = new ItemStack(Material.LIME_BANNER, 1);
		BannerMeta bannerMeta = (BannerMeta)banner.getItemMeta();

		List<Pattern> patterns = new ArrayList<Pattern>();

		patterns.add(new Pattern(DyeColor.YELLOW, PatternType.HALF_VERTICAL));
		patterns.add(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_LEFT));
		patterns.add(new Pattern(DyeColor.BLUE, PatternType.STRIPE_RIGHT));
		patterns.add(new Pattern(DyeColor.RED, PatternType.BORDER));

		bannerMeta.setPatterns(patterns);

		bannerMeta.displayName(Component.text("Pride"));
		banner.setItemMeta(bannerMeta);

		return banner;
	}
}
