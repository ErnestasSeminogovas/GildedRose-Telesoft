package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for ( Item item  : items) {

            if (!item.getName().equals(Constants.AGED_BRIE)
                    && !item.getName().contains(Constants.BACKSTAGE_PASSES)) {
                if (item.getQuality() > 0) {
                    if (!item.getName().equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
                        item.decreaseQuality();
                    }
                }
            } else {
                if (item.getQuality() < Constants.MAXIMUM_QUALITY) {
                    item.increaseQuality();

                    if (item.getName().contains(Constants.BACKSTAGE_PASSES)) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < Constants.MAXIMUM_QUALITY) {
                                item.increaseQuality();
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < Constants.MAXIMUM_QUALITY) {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!item.getName().equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
                item.decreaseSellIn();
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(Constants.AGED_BRIE)) {
                    if (!item.getName().contains(Constants.BACKSTAGE_PASSES)) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals(Constants.SULFURAS_HAND_OF_RAGNAROS)) {
                                item.decreaseQuality();
                            }
                        }
                    } else {
                        item.nullifyQuality();
                    }
                } else {
                    if (item.getQuality() < Constants.MAXIMUM_QUALITY) {
                        item.increaseQuality();
                    }
                }
            }
        }
    }
}