package com.eatfit.restaurant.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eatfit.restaurant.entity.Item;



import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query(value ="select * from items where item_name = :itemName", nativeQuery=true)
	/* @Query("SELECT i FROM items i WHERE i.item_name = ?1") */

	 List<Item> findByName(String itemName);
	
	@Query(value ="select * from items where item_type = :itemType", nativeQuery=true)
	/* @Query("SELECT i FROM items i WHERE i.item_name = ?1") */

 List<Item> findByItem(String itemType);
	
	
	
	 @Modifying
	    @Query(value = "insert into cart_items(cart_id,items_item_id) VALUES (:cartId,:itemId)", nativeQuery = true)
	    @Transactional
	   int insertCart(@Param("cartId") long cart_id, @Param("itemId") long itemId);

	
	 @Query(value ="select count(cart_id) from cart_items where cart_id = :cartId", nativeQuery=true)
	
	int getCartCount(long cartId);

}
