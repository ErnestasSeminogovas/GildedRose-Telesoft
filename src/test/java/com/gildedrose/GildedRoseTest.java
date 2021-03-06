package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void updateItemQuality() {
        Item[] items = new Item[]{
                new Item("Item 1", -2, 10), // Should decrease by 2
                new Item("Item 2", 2, 10), // Should decrease by 1
                new Item(Constants.SULFURAS_HAND_OF_RAGNAROS, -1, 10)}; // Should not change
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(8, app.items[0].getQuality());
        assertEquals(9, app.items[1].getQuality());
        assertEquals(10, app.items[2].getQuality());
    }


    @Test
    public void updateBackstagePassesQuality() {
        Item[] items = new Item[]{
                new Item(Constants.BACKSTAGE_PASSES, 0, 1), // Should be 0
                new Item(Constants.BACKSTAGE_PASSES, 2, 1), // Should increase by 3
                new Item(Constants.BACKSTAGE_PASSES, 9, 1), // Should increase by 2
                new Item(Constants.BACKSTAGE_PASSES, 15, 1)}; // Should increase by 1
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(0, app.items[0].getQuality());
        assertEquals(4, app.items[1].getQuality());
        assertEquals(3, app.items[2].getQuality());
        assertEquals(2, app.items[3].getQuality());
    }

    @Test
    public void updateAgedBrieQuality() {
        Item[] items = new Item[]{
                new Item(Constants.AGED_BRIE, -2, 1), // Should increase by 2
                new Item(Constants.AGED_BRIE, 2, 1)}; // Should increase by 1
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(3, app.items[0].getQuality());
        assertEquals(2, app.items[1].getQuality());
    }

    @Test
    public void updateConjuredItemQuality() {
        Item[] items = new Item[]{
                new Item(Constants.CONJURED_ITEM, -2, 10), // Should decrease by 4
                new Item(Constants.CONJURED_ITEM, 2, 10)}; // Should decrease by 2
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(6, app.items[0].getQuality());
        assertEquals(8, app.items[1].getQuality());
    }
}
