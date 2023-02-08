package com.gildedtros.itemquality;

import static com.gildedtros.configuration.InventoryConfig.*;

public final class ItemQualityFactory {

    private static final BackstagePassQuality BACKSTAGE_PASS_QUALITY = new BackstagePassQuality();
    private static final DegradingQuality DEGRADING_QUALITY = new DegradingQuality();
    private static final ImprovingQuality IMPROVING_QUALITY = new ImprovingQuality();
    private static final LegendaryQuality LEGENDARY_QUALITY = new LegendaryQuality();
    private static final SmellyQuality SMELLY_QUALITY = new SmellyQuality();

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
            return BACKSTAGE_PASS_QUALITY;
        } else if (isImprovingItem(itemName)) {
            return IMPROVING_QUALITY;
        } else if (isLegendaryItem(itemName)) {
            return LEGENDARY_QUALITY;
        } else if (isSmellyItem(itemName)) {
            return SMELLY_QUALITY;
        } else {
            return DEGRADING_QUALITY;
        }
    }
}
