package com.gildedtros.configuration;

import java.util.List;

public final class InventoryConfig {

    private static final int SELL_DATE_PASSED_BY = 0;

    private static final int QUALITY_LOWER_LIMIT = 0;
    private static final int QUALITY_UPPER_LIMIT = 50;
    private static final int QUALITY_LEGENDARY = 80;

    private static final List<String> IMPROVING_ITEMS = List.of("Good Wine");
    private static final List<String> LEGENDARY_ITEMS = List.of("B-DAWG Keychain");
    private static final List<String> BACKSTAGE_PASS_ITEMS = List.of("Backstage passes for Re:Factor", "Backstage passes for HAXX");
    private static final List<String> SMELLY_ITEMS = List.of("Duplicate Code", "Long Methods", "Ugly Variable Names");

    public static int getQualityOfLegendaryItem() {
        return QUALITY_LEGENDARY;
    }

    public static boolean isSellDatePassed(final int sellDate) {
        return sellDate < SELL_DATE_PASSED_BY;
    }

    public static boolean isQualityWithinLowerLimit(final int quality) {
        return quality > QUALITY_LOWER_LIMIT;
    }

    public static boolean isQualityWithinUpperLimit(final int quality) {
        return quality < QUALITY_UPPER_LIMIT;
    }

    public static boolean isImprovingItem(final String itemName) {
        return IMPROVING_ITEMS.contains(itemName);
    }

    public static boolean isLegendaryItem(final String itemName) {
        return LEGENDARY_ITEMS.contains(itemName);
    }

    public static boolean isBackstagePass(final String itemName) {
        return BACKSTAGE_PASS_ITEMS.contains(itemName);
    }

    public static boolean isSmellyItem(final String itemName) {
        return SMELLY_ITEMS.contains(itemName);
    }
}
