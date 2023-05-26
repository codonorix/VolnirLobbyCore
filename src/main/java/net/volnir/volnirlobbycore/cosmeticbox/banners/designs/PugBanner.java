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

public class PugBanner {
	public ItemStack pugBanner() {
		ItemStack banner = new ItemStack(Material.BLUE_BANNER, 1);
		BannerMeta bannerMeta = (BannerMeta)banner.getItemMeta();

		List<Pattern> patterns = new ArrayList<Pattern>();

		patterns.add(new Pattern(DyeColor.WHITE, PatternType.BRICKS));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_BOTTOM));
		patterns.add(new Pattern(DyeColor.BLUE, PatternType.BORDER));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.TRIANGLE_BOTTOM));
		patterns.add(new Pattern(DyeColor.PINK, PatternType.RHOMBUS_MIDDLE));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.CREEPER));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.FLOWER));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.CREEPER));
		patterns.add(new Pattern(DyeColor.GRAY, PatternType.CREEPER));
		patterns.add(new Pattern(DyeColor.BLUE, PatternType.TRIANGLE_TOP));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.CIRCLE_MIDDLE));

		bannerMeta.setPatterns(patterns);

		bannerMeta.displayName(Component.text("Pride"));
		banner.setItemMeta(bannerMeta);

		return banner;
	}
}
