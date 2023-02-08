package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DegradingItemTest {

    @Test
    void givenPositiveSellIn_WhenUpgradeQuality_ThenQualityDecreases() {
        Item[] items = new Item[]{new Item("Ring of Cleansening Code", 10, 20)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void givenSellInZero_WhenUpgradeQuality_ThenQualityDecreasesByTwo() {
        Item[] items = new Item[]{new Item("Ring of Cleansening Code", 0, 10)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void givenNegativeSellIn_WhenUpgradeQuality_ThenQualityDecreasesByTwo() {
        Item[] items = new Item[]{new Item("Ring of Cleansening Code", -2, 6)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void givenQualityZero_WhenUpgradeQuality_ThenQualityRemainsZero() {
        Item[] items = new Item[]{new Item("Ring of Cleansening Code", -5, 0)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-6, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
