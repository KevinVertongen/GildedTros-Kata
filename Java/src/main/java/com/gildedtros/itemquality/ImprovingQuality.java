package com.gildedtros.itemquality;

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
        return isWithinLimit(quality) ? quality + 1 : quality;
    }

    private boolean isWithinLimit(final int quality) {
        return quality < 50;
    }

    private boolean isSellDatePassed(final int sellDate) {
        return sellDate < 0;
    }
}
