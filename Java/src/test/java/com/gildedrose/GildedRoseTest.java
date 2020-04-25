package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

//    @Test
//    void foo() {
////        Item[] items = new Item[] { new Item("foo", 0, 0) };
////        GildedRose app = new GildedRose(items);
////        app.updateQuality();
////        assertEquals("fixme", app.items[0].getName());
//    }


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
}
