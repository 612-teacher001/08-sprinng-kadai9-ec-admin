package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "v_order_details")
public class VOrderDetail {
	@Id
	private int id;
	@Column(name = "item_id")
	private int itemId;
	
	private String name;
	private int price;
	private int quantity;
	
	@Column(name = "customer_id")
	private int customerId;
}
