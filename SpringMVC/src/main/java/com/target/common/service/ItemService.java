package com.target.common.service;

import org.springframework.web.client.RestTemplate;

import com.target.common.dao.Item;

public class ItemService {
	public static final String SERVER_URI = "http://localhost:8080/SpringMVC";
	// rest URI
	public static final String DUMMY_ITEM = "/rest/item/dummy";
	public static final String GET_ITEM = "/rest/item/{id}";
	public static final String GET_ALL_ITEM = "/item/emps";

	RestTemplate restTemplate;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Item getDummyItem() {
		RestTemplate restTemplate = new RestTemplate();
		Item item = restTemplate.getForObject(SERVER_URI + DUMMY_ITEM,
				Item.class);
		return item;
	}

}
