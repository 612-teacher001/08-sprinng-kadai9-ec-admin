package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 商品ID

	@Column(name = "category_id")
	private Integer categoryId; // カテゴリーID

	private String name; // 商品名

	private Integer price; // 価格

	@Transient // 永続化対象外
	private Integer quantity; // 数量

	/**
	 * TODO: SP90で新規追加
	 * デフォルトコンストラクタ
	 */
	public Item() {}
	
	/**
	 * TODO: SP90で新規追加
	 * コンストラクタ
	 * @param categoryId カテゴリID
	 * @param name       商品名
	 * @param price      価格
	 */
	public Item(int categoryId, String name, int price) {
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
	}

	/**
	 * TODO: SP90で新規追加
	 * コンストラクタ
	 * @param id         商品ID
	 * @param categoryId カテゴリID
	 * @param name       商品名
	 * @param price      価格
	 */
	public Item(int id, int categoryId, String name, int price) {
		this(categoryId, name, price);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
