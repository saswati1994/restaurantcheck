package com.eatfit.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eatfit.restaurant.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
