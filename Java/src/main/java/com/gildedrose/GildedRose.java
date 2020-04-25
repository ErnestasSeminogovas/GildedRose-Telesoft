package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateSellIn(item);
            updateQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        if (!item.getName().equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
            item.decreaseSellIn();
        }
    }

    private void updateQuality(Item item) {
        if (item.getName().contains(Constants.BACKSTAGE_PASSES)) {
            updateBackstagePassesQuality(item);
        } else if (item.getName().equals(Constants.AGED_BRIE)) {
            updateAgedBrieQuality(item);
        } else if (item.getName().contains(Constants.CONJURED_ITEM)) {
            updateConjuredItemQuality(item);
        } else if (!item.getName().equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
            item.decreaseQuality();
        }
    }

    private void updateBackstagePassesQuality(Item item) {
        if (item.getSellIn() < 0) {
            item.nullifyQuality();
        } else if (item.getSellIn() < 5) {
            item.increaseQualityByValue(3);
        } else if (item.getSellIn() < 10) {
            item.increaseQualityByValue(2);
        } else {
            item.increaseQuality();
        }
    }

    private void updateAgedBrieQuality(Item item) {
        if (item.getSellIn() < 0) {
            item.increaseQualityByValue(2);
        }
        else  {
            item.increaseQuality();
        }
    }

    private void updateConjuredItemQuality(Item item) {
        if (item.getSellIn() < 0) {
            item.decreaseQualityByValue(4);
        }
        else  {
            item.decreaseQualityByValue(2);
        }
    }

}