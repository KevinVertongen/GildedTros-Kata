package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassTest {

    @Test
    void givenSellInOver10Days_WhenUpgradeQuality_ThenQualityIncreasesByOne() {
        Item[] items = new Item[]{new Item("Backstage passes for Re:Factor", 15, 20)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void givenSellIn10Days_WhenUpgradeQuality_ThenQualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes for Re:Factor", 10, 40)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void givenSellIn5Days_WhenUpgradeQuality_ThenQualityIncreasesByThree() {
        Item[] items = new Item[]{new Item("Backstage passes for HAXX", 5, 45)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void givenSellInZero_WhenUpgradeQuality_ThenQualityDropsToZero() {
        Item[] items = new Item[]{new Item("Backstage passes for HAXX", 0, 50)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenNegativeSellIn_WhenUpgradeQuality_ThenQualityRemainsZero() {
        Item[] items = new Item[]{new Item("Backstage passes for HAXX", 0, 50)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenQuality49_WhenUpgradeQuality_ThenQualityNotOver50() {
        Item[] items = new Item[]{new Item("Backstage passes for Re:Factor", 10, 49)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
