package com.eatfit.restaurant.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	 // @SequenceGenerator(sequenceName = "cart_seq", name = "cart_seq_gen", allocationSize = 1)
	  @GeneratedValue(strategy = GenerationType.IDENTITY/*, generator = "cart_seq_gen"*/)
	  @Column(name = "order_id")
	  private Long orderId;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	  @JoinColumn(name = "order_cartId")
	  private Cart cart;

	  @Column(name = "date")
	  private Date placedDate;
	  
	  @Column(name="status")
     private String status;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Date getPlacedDate() {
		return placedDate;
	}

	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Orders(Long orderId, Cart cart, Date placedDate, String status) {
		super();
		this.orderId = orderId;
		this.cart = cart;
		this.placedDate = placedDate;
		this.status = status;
	}

	public Orders() {
		super();
	}

	  
}
