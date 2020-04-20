package com.eatfit.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eatfit.restaurant.dto.ItemDto;
import com.eatfit.restaurant.entity.Item;

@Service
public interface ItemService {

	public void addItem(ItemDto itemDto);

	public List<Item> displayAllItems() ;

	public void updateItem(long id, ItemDto itemDto);

	public void deleteItem(long id) ;

	//CartItem
		/* CartItem createCartItem(CartItem cartItem); */
		
		 List<Item> getAllItem(); 
		
		
		/* void deleteProduct(long cartId); */
}
