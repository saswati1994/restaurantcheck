package com.eatfit.restaurant.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eatfit.restaurant.dto.ItemDto;
import com.eatfit.restaurant.entity.Item;
import com.eatfit.restaurant.repository.ItemRepository;
import com.eatfit.restaurant.service.ItemService;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@CrossOrigin(origins="*")
@RequestMapping("/items")
public class ItemAdminController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemRepository itemRepository;
	
	
	@GetMapping("")
	public ModelAndView home() {
		return new ModelAndView("homeitem");
	}
	
	
	/*
	 * adding a new item into the restaurant menu
	 */
	@PostMapping("/add")
	public String addItem(@Valid ItemDto itemDto) {
		
			itemService.addItem(itemDto);
			logger.info("Adding new Item");
			
			return "redirect:/items/display";
			
	}
	
	
	@GetMapping("/item")
	public ModelAndView add() {
		return new ModelAndView("additem");
	} 
	
	
	/*
	 * displaying all the items in the menu
	 */
	@GetMapping("/display")
	public String displayAllItems(ModelMap model) {
		
		List<Item> items=itemService.displayAllItems();
		if(items.isEmpty())
			return "homeitem";
		model.addAttribute("items", items);

		return "displayitems";
	}
	
	/*
	 * displaying an item using item id
	 */
	@GetMapping("/displayitem/{itemId}")
	public String displayItemById(ModelMap model,@PathVariable String itemId) {
	
		long id=Long.parseLong(itemId);
		Optional<Item> item=itemRepository.findById(id);
		logger.info("displaying item");
		model.addAttribute("item", item.get());
		
		return "updateitem";
		
	}
	
		/*
		 * updating an item using item id
		 */
		@PostMapping("/update/{itemId}")
		public String updateItem(@PathVariable String itemId, @Valid ItemDto itemDto) {
		
			long id=Long.parseLong(itemId);
			itemService.updateItem(id, itemDto);
			
			return "redirect:/items/display";
	}
		
		/*
		 * deleting an item using item id
		 */
		@GetMapping("/delete/{id}")
		public String deleteItem(@PathVariable String id) {
			long itemId=Long.parseLong(id);
			itemService.deleteItem(itemId);
			return "redirect:/items/display";
		}
		
		/*
		 * to handle invalid input type 
		 */
		@ExceptionHandler(HttpMessageNotReadableException.class)
		@ResponseBody
		public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex)
		{
		    JsonMappingException jme = (JsonMappingException) ex.getCause();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exceptionMessage: "+ jme.getPath().get(0).getFieldName() + " invalid");
		}


}
