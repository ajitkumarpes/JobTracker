package com.target.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.target.common.dao.Item;
import com.target.common.dao.ItemDetails;
import com.target.common.dao.Price;

@Controller
public class RestItemController {

	public static final String DUMMY_ITEM = "/rest/item/dummy";
	public static final String GET_ITEM = "/rest/item/{id}";
	public static final String GET_ALL_ITEM = "/item/emps";
	// Map to store items, ideally we should use database
	Map<Long, Item> itemData = new HashMap<Long, Item>();

	@RequestMapping(value = DUMMY_ITEM, method = RequestMethod.GET)
	public @ResponseBody Item getDummyItem() {

		Item item = createDummyItem();
		itemData.put(123456L, item);
		return item;
	}

	@RequestMapping(value = GET_ITEM, method = RequestMethod.GET)
	public @ResponseBody Item getItem(@PathVariable("id") int itemId) {

		return itemData.get(itemId);
	}

	@RequestMapping(value = GET_ALL_ITEM, method = RequestMethod.GET)
	public @ResponseBody List<Item> getAllItems() {

		List<Item> items = new ArrayList<Item>();
		Set<Long> itemIdKeys = itemData.keySet();
		for (Long i : itemIdKeys) {
			items.add(itemData.get(i));
		}
		return items;
	}

	public Item createDummyItem() {

		Item item = new Item();
		item.setId(123456L);
		ItemDetails itemForm = new ItemDetails();
		// Dummy value 
		// List Price
		Price price = new Price();
		price.setFormattedPrice("10.3");
		price.setMaxPrice(12.5);
		price.setMinPrice(5.8);
		price.setPrice(65.7);
		price.setPriceType("RS");
		itemForm.setListPrice(price);

		// offer Price
		Price offerPrice = new Price();
		offerPrice.setFormattedPrice("2324.78");
		offerPrice.setMaxPrice(124325.5);
		offerPrice.setMinPrice(50000.8);
		offerPrice.setPrice(65080.7);
		offerPrice.setPriceType("RS");
		itemForm.setOfferPrice(offerPrice);

		itemForm.setLastUpdate(new Date(1000000));
		itemForm.setMapPrice(20D);
		itemForm.setMapPriceFlag("Y");
		itemForm.setPartNumber("11111");
		itemForm.setPpu("PPU");
		itemForm.setSoiFlag("N");
		item.setItemDetails(itemForm);
		return item;
	}

}
