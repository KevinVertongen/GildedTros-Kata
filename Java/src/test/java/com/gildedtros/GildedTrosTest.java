package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedTros app = new GildedTros(items);

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenDegradingItem_WithPositiveSellIn_WhenUpgradeQuality_ThenQualityDecreases() {
        Item[] items = new Item[]{new Item("Ring of Cleansening Code", 10, 20)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void givenImprovingItem_WithPositiveSellIn_WhenUpgradeQuality_ThenQualityIncreases() {
        Item[] items = new Item[]{new Item("Good Wine", 2, 0)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void givenLegendaryItem_WithSellInZero_WhenUpgradeQuality_ThenSellInUnchanged_AndQualityUnchanged() {
        Item[] items = new Item[]{new Item("B-DAWG Keychain", 0, 80)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenLegendaryItem_WithNegativeSellIn_WhenUpgradeQuality_ThenSellInUnchanged_AndQualityUnchanged() {
        Item[] items = new Item[]{new Item("B-DAWG Keychain", -1, 80)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenBackStagePass_WithSellInOver10Days_WhenUpgradeQuality_ThenQualityIncreasesByOne() {
        Item[] items = new Item[]{new Item("Backstage passes for Re:Factor", 15, 20)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void givenBackStagePass_WithSellIn10Days_WhenUpgradeQuality_ThenQualityIncreasesByTwo() {
        Item[] items = new Item[]{new Item("Backstage passes for Re:Factor", 10, 40)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void givenBackStagePass_WithSellIn5Days_WhenUpgradeQuality_ThenQualityIncreasesByThree() {
        Item[] items = new Item[]{new Item("Backstage passes for HAXX", 5, 45)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void givenBackStagePass_WithQuality49_WhenUpgradeQuality_ThenQualityNotOver50() {
        Item[] items = new Item[]{new Item("Backstage passes for Re:Factor", 10, 49)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

}
