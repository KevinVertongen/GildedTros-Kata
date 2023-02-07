package com.gildedtros.configuration;

import java.util.List;

public final class InventoryConfig {

    private static final List<String> IMPROVING_ITEMS = List.of("Good Wine");
    private static final List<String> LEGENDARY_ITEMS = List.of("B-DAWG Keychain");
    private static final List<String> BACKSTAGE_PASS_ITEMS = List.of("Backstage passes for Re:Factor", "Backstage passes for HAXX");

    public static boolean isImprovingItem(final String itemName) {
        return IMPROVING_ITEMS.contains(itemName);
    }

    public static boolean isLegendaryItem(final String itemName) {
        return LEGENDARY_ITEMS.contains(itemName);
    }

    public static boolean isBackstagePass(final String itemName) {
        return BACKSTAGE_PASS_ITEMS.contains(itemName);
    }
}
