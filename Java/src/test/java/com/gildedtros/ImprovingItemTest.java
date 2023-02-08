package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImprovingItemTest {

    @Test
    void givenPositiveSellIn_WhenUpgradeQuality_ThenQualityIncreases() {
        Item[] items = new Item[]{new Item("Good Wine", 2, 0)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void givenSellInZero_WhenUpgradeQuality_ThenQualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Good Wine", 2, 0)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void givenNegativeSellIn_WhenUpgradeQuality_ThenQualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Good Wine", -2, 6)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void givenQuality50_WhenUpgradeQuality_ThenQualityNotOver50() {
        Item[] items = new Item[]{new Item("Good Wine", -27, 50)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-28, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
