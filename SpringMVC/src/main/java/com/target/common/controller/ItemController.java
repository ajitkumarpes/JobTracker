package com.target.common.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.target.common.dao.Item;
import com.target.common.service.ItemService;

@Controller
@RequestMapping(value = "/itemCheck")
public class ItemController {

	public static final String SERVER_URI = "http://dcdlx2009/item/price/qa2/v1";

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private ItemService itemService;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewItem(Map<String, Object> model) {
		Item itemForm = new Item();
		model.put("itemForm", itemForm);

		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String itemCheck(ModelMap model,
			@ModelAttribute("itemForm") Item item, BindingResult result) {

		Item itemForm = restTemplate.getForObject(
				SERVER_URI + "/" + item.getId(), Item.class);

		model.put("itemForm", itemForm);

		return "home";

	}

	@RequestMapping(value = "/dummyItem", method = RequestMethod.GET)
	public String viewDummyItem(Map<String, Object> model) {

		Item itemForm = itemService.getDummyItem();
		model.put("itemForm", itemForm);

		return "home";
	}
}