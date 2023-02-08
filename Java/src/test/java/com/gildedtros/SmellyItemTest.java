package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmellyItemTest {

    @Test
    void givenPositiveSellIn_WhenUpgradeQuality_ThenQualityDecreasesByTwo() {
        Item[] items = new Item[]{new Item("Duplicate Code", 3, 6)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void givenSellInZero_WhenUpgradeQuality_ThenQualityDecreasesByFour() {
        Item[] items = new Item[]{new Item("Long Methods", 0, 6)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void givenNegativeSellIn_WhenUpgradeQuality_ThenQualityDecreasesByFour() {
        Item[] items = new Item[]{new Item("Ugly Variable Names", -2, 4)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenQualityZero_WhenUpgradeQuality_ThenQualityRemainsZero() {
        Item[] items = new Item[]{new Item("God Class", -3, 0)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
