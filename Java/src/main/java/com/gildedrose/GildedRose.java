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
        } else {
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

}