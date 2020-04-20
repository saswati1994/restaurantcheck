package com.eatfit.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatfit.restaurant.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
