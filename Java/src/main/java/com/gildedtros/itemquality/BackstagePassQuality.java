package com.gildedtros.itemquality;

public class BackstagePassQuality implements ItemQualityStrategy {

    /**
     * Calculate the quality of an item by following rules:
     * <ul>
     *     <li>Quality increases by 1 when there are more then 10 days.</li>
     *     <li>Quality increases by 2 when there are 10 days or less.</li>
     *     <li>Quality increases by 3 when there are 5 days or less.</li>
     *     <li>Quality drops to 0 when there are less then 0 days.</li>
     *     <li>The Quality of an item is never more than 50.</li>
     * </ul>
     */
    @Override
    public int calculateQuality(final int quality, final int sellIn) {
        return 0;
    }
}
