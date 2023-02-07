package com.gildedtros.itemquality;

public interface ItemQualityStrategy {

    /**
     * Calculate the quality of an item for its days left to sell.
     *
     * @param quality current item quality
     * @param sellIn  number of days left to sell the item
     * @return Updated item quality
     */
    int calculateQuality(int quality, int sellIn);
}
