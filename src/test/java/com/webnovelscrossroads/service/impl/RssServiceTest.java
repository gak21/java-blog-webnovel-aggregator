package com.webnovelscrossroads.service.impl;

import org.junit.Before;

public class RssServiceTest {

	private RssService rssService;
	
	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}
	/*
	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
		assertEquals(10, items.size());
		Item firstItem = items.get(0);
		assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
		assertEquals("2014", new SimpleDateFormat("yyyy").format(firstItem.getPublishedDate()));
	}*/

}
