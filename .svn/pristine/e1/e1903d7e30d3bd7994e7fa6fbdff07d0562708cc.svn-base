package com.eatfit.restaurant.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eatfit.restaurant.dto.ItemDto;
import com.eatfit.restaurant.entity.Item;
import com.eatfit.restaurant.repository.ItemRepository;
import com.eatfit.restaurant.service.ItemService;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;


@RestController
@Slf4j
@CrossOrigin(origins="*")
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemRepository itemRepository;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	
	
	
	
		//CartItem
		 @GetMapping("/itemlist")

	     public ResponseEntity<List<Item>> getAllItem(){ return
		 ResponseEntity.ok().body(itemService.getAllItem()); }
		 
		
		
		 @GetMapping("/type/{itemType}")
			
			public  List<Item> findByItem(@PathVariable("itemType") String itemType)
			{
			 return itemRepository.findByItem(itemType);
			
			}
		
		 @GetMapping("/items/search/{itemName}")


			
			public  List<Item> findByName(@PathVariable String itemName)
			{
			 return itemRepository.findByName(itemName);
			
			}
		 
		 //SearchByName
		 @PostMapping(value="/searchitem")
	     public Map<String, Object>  namelist(String itemName) {           
	           System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	           //ModelMap map = new ModelMap();
	           Map<String, Object> map = new HashMap<>();
	          map.put("userList",itemRepository.findByName(itemName));
	          map.put("countvalue", itemRepository.getCartCount(1) );
	        
	          return map;
	     }
		 //List All Items
		 @GetMapping(value="/list")
	     public ModelAndView list(ModelMap map,HttpSession sess) {           
	             
	          map.addAttribute("userList",itemService.getAllItem());
	          map.addAttribute("countvalue", itemRepository.getCartCount(1) );


	          return new ModelAndView("itemlist");
	     }
		 
		 @GetMapping(value="/{itemType}")

		  public ModelAndView list(@PathVariable String itemType ,ModelMap map,HttpSession sess) 
		{
			map.addAttribute("userList",itemRepository.findByItem(itemType));
			 return new ModelAndView("itemlist");
		
		}
		// Add Cart to item		
		@PostMapping("/addNewCart")
		
		public int processRequest(@RequestParam("itemId") String itemId ) {
			
			System.out.println(">>>>>>>>>>"+itemId);
			long i = Long.parseLong(itemId);
			
		return 	itemRepository.insertCart(1, i);
	
		}
		//Display Count
		@GetMapping(value="/displayCount")
		
		public int getCount(Long cartId)
		
		{
	return itemRepository.getCartCount(1);
		
		}
		
		
	
		
}
