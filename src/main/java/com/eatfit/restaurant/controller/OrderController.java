package com.eatfit.restaurant.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eatfit.restaurant.dto.OrderDto;
import com.eatfit.restaurant.entity.Cart;
import com.eatfit.restaurant.entity.Item;
import com.eatfit.restaurant.entity.Orders;
import com.eatfit.restaurant.exception.OrderNotFoundException;
import com.eatfit.restaurant.repository.CartRepository;
import com.eatfit.restaurant.repository.OrderRepository;
import com.eatfit.restaurant.service.OrderService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	/*
	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto){
		return orderService.placeOrder(orderDto);
		
		
	}*/
	
	@PostMapping("/order")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderDto orderDto,ModelMap model){
		Orders order = orderService.placeOrder(orderDto);
		Long orderid = order.getOrderId();
		model.put("orders", order);
		 return new ResponseEntity<Long>( orderid, HttpStatus.PERMANENT_REDIRECT);
		
	}
	
	@GetMapping("/order")
    public String placeOrder(@RequestParam Long orderId,ModelMap model) {
		java.util.Optional<Orders> orders = orderRepository.findById(orderId);
		Orders oredr = orders.get();
		List<Item> item = oredr.getCart().getItems();
		String userid = oredr.getCart().getUserId();
		Date placeddate = oredr.getPlacedDate();
		Cart cart = oredr.getCart();
		model.put("orderid", orderId);
		model.put("order", oredr);
		model.put("item", item);
		model.put("userid", userid);
		model.put("placeddate", placeddate);
		model.put("cart",cart);
		return "SuccessOrder";
    }
	
	@GetMapping("/order/{orderId}")
	public String getOrderById(@PathVariable Long orderId,ModelMap model){
		
		logger.info("calling service method to get order by id");
		java.util.Optional<Orders> order = orderService.getOrderById(orderId);
		Orders orders = new Orders();
		
		if(order.isPresent()) {
			orders = order.get();
			model.put("order", orders);
			return "vieworder";
		}else {
			throw new OrderNotFoundException("OrderNotFoundException");
		}
		
	}
	
	@GetMapping("/orders")
		public ResponseEntity<List<Orders>> getOrders(){
		List<Orders> orders = orderService.getOrders();
		if(orders.isEmpty()) {
			throw new OrderNotFoundException("OrderNotFoundException");
		}else {
			return new ResponseEntity<List<Orders>>(orders,HttpStatus.OK);
		}
		
		}
	
//	@PutMapping("/order/cancel/{orderId}")
//	public ResponseEntity<String> cancelOrder(@PathVariable Long orderId){
//		
//		boolean result = orderService.cancelOrder(orderId);
//		if(result) {
//			return new ResponseEntity<String>("order cancelled for orderId" +orderId,HttpStatus.OK);
//			
//		}else {
//			
//			throw new OrderNotFoundException("OrderNotFoundException");
//		}
//		
//		
//	}
	
	@GetMapping("/order/cancel/{orderId}")
    public String cancelOrder(@PathVariable String orderId){
       
        long orderid = Long.parseLong(orderId);
       
        boolean result = orderService.cancelOrder(orderid);
         return "cancelorder";
       
       
    }
    @GetMapping("/order/cancel")
        public String returnCancelPage() {
            return "cancelorder";
       }
    @GetMapping("/cart/{cartId}")
	  public String getCartItemById(@PathVariable Long cartId,ModelMap model) {
		  Cart cart =new Cart();
		 // Item item =new Item();
		  Long totalPrice =0L;
		  List<Item> items = new ArrayList<Item>();
		 java.util.Optional<Cart> cartOptions = cartRepository.findById(cartId);
		 if(cartOptions.isPresent()) {
			  cart = cartOptions.get();
			 
					 items=  cart.getItems();
		 }else {
			 
		 }
		 for(Item item:items) {
			 Long price = item.getPrice();
			 totalPrice =totalPrice+ price;
		 }
		 model.put("totalPrice", totalPrice);
		 model.put("cartitems", cart);
		 model.put("items", items);
		return "ViewCart";
		  
	  }
	
	}

