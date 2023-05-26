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

public class CatBanner {
	public ItemStack catBanner() {
		ItemStack banner = new ItemStack(Material.WHITE_BANNER, 1);
		BannerMeta bannerMeta = (BannerMeta)banner.getItemMeta();

		List<Pattern> patterns = new ArrayList<Pattern>();

		patterns.add(new Pattern(DyeColor.BLACK, PatternType.DIAGONAL_RIGHT_MIRROR));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.DIAGONAL_LEFT_MIRROR));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.DIAGONAL_LEFT));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.DIAGONAL_RIGHT));
		patterns.add(new Pattern(DyeColor.WHITE, PatternType.CURLY_BORDER));
		patterns.add(new Pattern(DyeColor.WHITE, PatternType.SQUARE_TOP_LEFT));
		patterns.add(new Pattern(DyeColor.WHITE, PatternType.TRIANGLES_TOP));
		patterns.add(new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_BOTTOM));
		patterns.add(new Pattern(DyeColor.BLACK, PatternType.MOJANG));

		bannerMeta.setPatterns(patterns);

		bannerMeta.displayName(Component.text("Cat"));
		banner.setItemMeta(bannerMeta);

		return banner;
	}
}
