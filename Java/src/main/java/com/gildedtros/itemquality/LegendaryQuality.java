package com.gildedtros.itemquality;

import com.gildedtros.configuration.InventoryConfig;

import static com.gildedtros.configuration.InventoryConfig.getQualityOfLegendaryItem;

public class LegendaryQuality implements ItemQualityStrategy {

    /**
     * Package private, client should use the {@link ItemQualityFactory} to get a concrete {@link ItemQualityStrategy}.
     */
    LegendaryQuality() {
    }

    /**
     * Legendary items have a fixed quality.
     *
     * @see InventoryConfig#getQualityOfLegendaryItem()
     */
    @Override
    public int calculateQuality(final int quality, final int sellIn) {
        return getQualityOfLegendaryItem();
    }
}
