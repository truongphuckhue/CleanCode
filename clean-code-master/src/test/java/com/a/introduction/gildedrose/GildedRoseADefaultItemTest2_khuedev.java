package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest2_khuedev {
	private static final int EXPIRED_SELLIN = -2;
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	private static final int DEFAULT_QUALITY = 4;
	private static final int NOT_EXPIRED_SELLIN = 16;
	
	@Test
	public void unexpiredDefaultItem_qualityDecreasesBy1() {
		
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, 
						NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(DEFAULT_ITEM, 
						NOT_EXPIRED_SELLIN - 1,DEFAULT_QUALITY - 1);
			
		assertItem(expected, app.items[0]);
	}
	
	@Test
	public void expiredDefaultItem_qualityDecreasesBy2() {
		
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, 
						EXPIRED_SELLIN , DEFAULT_QUALITY);
		
		app.updateQuality();
		
		Item expected = new Item(DEFAULT_ITEM, 
				EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);
			
		assertItem(expected, app.items[0]);
	}
	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithOneItem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}
}