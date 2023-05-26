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

public class MatrixBanner {
	public ItemStack matrixBanner() {
		ItemStack banner = new ItemStack(Material.MAGENTA_BANNER, 1);
		BannerMeta bannerMeta = (BannerMeta)banner.getItemMeta();

		List<Pattern> patterns = new ArrayList<Pattern>();

		patterns.add(new Pattern(DyeColor.PURPLE, PatternType.GRADIENT_UP));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.BRICKS));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_SMALL));
		bannerMeta.setPatterns(patterns);

		bannerMeta.displayName(Component.text("Matrix"));
		banner.setItemMeta(bannerMeta);

		return banner;
	}
}
