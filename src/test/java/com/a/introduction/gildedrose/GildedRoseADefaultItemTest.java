package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

 class GildedRoseADefaultItemTest {

	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int UNEXPIRED_SELL_IN = 15;
	public static final int QUALITY = 3;
	public static final int EXPIRED_SELL_IN = -1;

	@Test
	 void shouldReturnQualityDecreasedByOneForUnExpiredItem() {
		GildedRose glidedRoseItem = createNewGlidedRoseItem(DEFAULT_ITEM, UNEXPIRED_SELL_IN, QUALITY);

		glidedRoseItem.updateQuality();

		Item expectedItem = new Item(DEFAULT_ITEM, UNEXPIRED_SELL_IN -1, QUALITY -1);
		assertItem(glidedRoseItem.items[0], expectedItem);
	}

	@Test
	 void testUpdateQualityForExpiredItem() {
		GildedRose glidedRoseItem = createNewGlidedRoseItem(DEFAULT_ITEM, EXPIRED_SELL_IN, QUALITY);

		glidedRoseItem.updateQuality();

		Item expectedItem = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, QUALITY - 2);
		assertItem(glidedRoseItem.items[0],expectedItem);
	}

	private void assertItem(Item actualItem, Item expectedItem) {
		assertEquals(expectedItem.name, actualItem.name);
		assertEquals(expectedItem.sellIn, actualItem.sellIn);
		assertEquals(expectedItem.quality, actualItem.quality);
	}

	private GildedRose createNewGlidedRoseItem(String default_item, int sellIn, int quality) {
		Item item = new Item(default_item, sellIn, quality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

}