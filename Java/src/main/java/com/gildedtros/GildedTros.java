package com.gildedtros;

import com.gildedtros.itemquality.ItemQualityFactory;
import com.gildedtros.itemquality.ItemQualityStrategy;

import static com.gildedtros.configuration.InventoryConfig.isLegendaryItem;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (final Item item : items) {
            final String itemName = item.name;

            // a legendary item never has to be sold or decreases in Quality
            if (isLegendaryItem(itemName)) {
                continue;
            }

            item.sellIn = item.sellIn - 1;

            final ItemQualityStrategy itemQuality = ItemQualityFactory.getItemQualityStrategy(itemName);
            item.quality = itemQuality.calculateQuality(item.quality, item.sellIn);
        }
    }
}
