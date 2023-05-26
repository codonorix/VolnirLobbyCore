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

public class TheEyeBanner {
	public ItemStack theEyeBanner() {
		ItemStack banner = new ItemStack(Material.WHITE_BANNER, 1);
		BannerMeta bannerMeta = (BannerMeta)banner.getItemMeta();

		List<Pattern> patterns = new ArrayList<Pattern>();

		patterns.add(new Pattern(DyeColor.RED, PatternType.RHOMBUS_MIDDLE));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.STRIPE_BOTTOM));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.STRIPE_TOP));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.CURLY_BORDER));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.HALF_HORIZONTAL));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.STRIPE_BOTTOM));

		bannerMeta.setPatterns(patterns);

		bannerMeta.displayName(Component.text("The Eye"));
		banner.setItemMeta(bannerMeta);

		return banner;
	}
}
