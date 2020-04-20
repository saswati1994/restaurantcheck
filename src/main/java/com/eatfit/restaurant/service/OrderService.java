package com.eatfit.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eatfit.restaurant.dto.OrderDto;
import com.eatfit.restaurant.entity.Cart;
import com.eatfit.restaurant.entity.Orders;
import com.eatfit.restaurant.exception.CartNotFoundException;
import com.eatfit.restaurant.repository.CartRepository;
import com.eatfit.restaurant.repository.OrderRepository;



@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CartRepository cartRepository;

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	public Orders placeOrder(OrderDto orderDto) {
		Optional<Cart> cart = cartRepository.findById(orderDto.getCart().getCartId());
		logger.info("checking orderId present or not");
		if (cart.isPresent()) {
			Orders order = new Orders();
			order.setCart(orderDto.getCart());
			order.setPlacedDate(orderDto.getPlacedDate());
			order.setStatus("CREATED");
			
			Orders orders=orderRepository.save(order);
			logger.info("order placed");
			return orders;

		} else {
			throw new CartNotFoundException("cartNotFoundException");
		}

	}

	public Optional<Orders> getOrderById(Long orderId) {

		return orderRepository.findById(orderId);
	}

	public List<Orders> getOrders() {
		return orderRepository.findAll();
	}
	
	public boolean cancelOrder(Long orderId) {
		Optional<Orders> order = orderRepository.findById(orderId);
		if(order.isPresent()) {
			order.get().setStatus("CANCELLED");
			orderRepository.save(order.get());
			return true;
		}else {
			return false;
		}
		
		
		
	}
}

