package com.gildedtros.itemquality;

import static com.gildedtros.configuration.InventoryConfig.isQualityWithinLowerLimit;
import static com.gildedtros.configuration.InventoryConfig.isSellDatePassed;

public class DegradingQuality implements ItemQualityStrategy {

    /**
     * Calculate the quality of an item by following rules:
     * <ul>
     *     <li>Quality degrades by 1.</li>
     *     <li>Quality degrades by 2 when sell by date is less then zero.</li>
     *     <li>Quality is never negative.</li>
     * </ul>
     */
    @Override
    public int calculateQuality(final int quality, final int sellIn) {
        final int updatedQuality = decreaseQuality(quality);
        return isSellDatePassed(sellIn) ? decreaseQuality(updatedQuality) : updatedQuality;
    }

    private int decreaseQuality(final int quality) {
        return isQualityWithinLowerLimit(quality) ? quality - 1 : quality;
    }
}
