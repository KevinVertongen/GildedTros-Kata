package com.gildedtros.itemquality;

import static com.gildedtros.configuration.InventoryConfig.isQualityWithinLowerLimit;
import static com.gildedtros.configuration.InventoryConfig.isSellDatePassed;

public class SmellyQuality implements ItemQualityStrategy {

    /**
     * Package private, client should use the {@link ItemQualityFactory} to get a concrete {@link ItemQualityStrategy}.
     */
    SmellyQuality() {
    }

    /**
     * Calculate the quality of an item by following rules:
     * <ul>
     *     <li>Quality degrades by 2.</li>
     *     <li>Quality degrades by 4 when sell by date is less then zero.</li>
     *     <li>Quality is never negative.</li>
     * </ul>
     */
    @Override
    public int calculateQuality(final int quality, final int sellIn) {
        final int updatedQuality = decreaseQualityTwice(quality);
        return isSellDatePassed(sellIn) ? decreaseQualityTwice(updatedQuality) : updatedQuality;
    }

    private int decreaseQualityTwice(final int quality) {
        final int decreasedOnce = isQualityWithinLowerLimit(quality) ? quality - 1 : quality;
        return isQualityWithinLowerLimit(decreasedOnce) ? decreasedOnce - 1 : decreasedOnce;
    }
}
