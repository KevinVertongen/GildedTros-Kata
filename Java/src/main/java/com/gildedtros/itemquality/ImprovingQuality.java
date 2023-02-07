package com.gildedtros.itemquality;

import static com.gildedtros.configuration.InventoryConfig.isQualityWithinUpperLimit;
import static com.gildedtros.configuration.InventoryConfig.isSellDatePassed;

public class ImprovingQuality implements ItemQualityStrategy {

    /**
     * Calculate the quality of an item by following rules:
     * <ul>
     *     <li>Quality increases by 1.</li>
     *     <li>Quality increases by 2 when sell by date is less then zero.</li>
     *     <li>Quality is never more then 50.</li>
     * </ul>
     */
    @Override
    public int calculateQuality(final int quality, final int sellIn) {
        final int updatedQuality = increaseQuality(quality);
        return isSellDatePassed(sellIn) ? increaseQuality(updatedQuality) : updatedQuality;
    }

    private int increaseQuality(final int quality) {
        return isQualityWithinUpperLimit(quality) ? quality + 1 : quality;
    }
}
