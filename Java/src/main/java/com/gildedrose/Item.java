package com.gildedrose;

public class Item {

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void increaseQuality() {
        if (this.quality < Constants.MAXIMUM_QUALITY) {
            this.quality++;
        }
    }

    public void increaseQualityByValue(int value) {
        if (this.quality + value < Constants.MAXIMUM_QUALITY) {
            this.quality = this.quality + value;
        }
        else {
            this.quality = Constants.MAXIMUM_QUALITY;
        }
    }

    public void decreaseQuality() {
        if (this.quality > 0) {
            if (this.sellIn <= 0) {
                decreaseQualityByValue(2);
            }
            else {
                this.quality--;
            }
        }
    }

    public void decreaseQualityByValue(int value) {
        if (this.quality - value  > 0) {
            this.quality = this.quality - value;
        }
        else {
            nullifyQuality();
        }
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public void nullifyQuality() {
        this.quality = 0;
    }
}
