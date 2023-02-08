package com.gildedtros.itemquality;

import static com.gildedtros.configuration.InventoryConfig.*;

public final class ItemQualityFactory {

    /*
     * No need instantiate a Static Factory
     */
    private ItemQualityFactory() {
    }

    /**
     * Find the appropriate {@link ItemQualityStrategy} to calculate quality for the given item name.
     *
     * @param itemName Name of the item.
     * @return the appropriate {@link ItemQualityStrategy} for the item.
     */
    public static ItemQualityStrategy getItemQualityStrategy(final String itemName) {
        if (isBackstagePass(itemName)) {
            return new BackstagePassQuality();
        } else if (isImprovingItem(itemName)) {
            return new ImprovingQuality();
        } else if (isLegendaryItem(itemName)) {
            return new LegendaryQuality();
        } else {
            return new DegradingQuality();
        }
    }
}
