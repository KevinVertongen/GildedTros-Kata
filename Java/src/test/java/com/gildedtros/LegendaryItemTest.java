package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegendaryItemTest {

    @Test
    void givenSellInZero_WhenUpgradeQuality_ThenSellInUnchanged_AndQualityUnchanged() {
        Item[] items = new Item[]{new Item("B-DAWG Keychain", 0, 80)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenNegativeSellIn_WhenUpgradeQuality_ThenSellInUnchanged_AndQualityUnchanged() {
        Item[] items = new Item[]{new Item("B-DAWG Keychain", -1, 80)};

        GildedTros app = new GildedTros(items);

        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
}
