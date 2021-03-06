package com.gildedrose;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      if (isAgedBrie(item)) {
        increaseQuality(item);
      } else if (isBackstage(item)) {
        increaseQuality(item);
        if (item.sellIn < 11) {
          increaseQuality(item);
        }
        if (item.sellIn < 6) {
          increaseQuality(item);
        }
        // }
      } else {
        if (isSulfuras(item)) {
        } else if(isConjured) {
          decreaseQuality(item);
          decreaseQuality(item);
        }
      }

      if (isSulfuras(item)) {
      } else {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (isAgedBrie(item)) {
          increaseQuality(item);
        } else {
          if (isBackstage(item)) {
            item.quality = 0;
          } else {
            if (isSulfuras(item)) {
              continue;
            }
            decreaseQuality(item);

          }
        }
      }
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  private void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  private boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private boolean isBackstage(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }
  private boolean isConjured(Item item) {
    return item.name.equals("Conjured Mana Cake");
  }
}
