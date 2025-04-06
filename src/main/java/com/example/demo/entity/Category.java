package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // カテゴリーID

	private String name; // カテゴリー名

	/**
	 * TODO: SP90で新規追加
	 * デフォルトコンストラクタ
	 */
	public Category() {}
	
	/**
	 * TODO: SP90で新規追加
	 * コンストラクタ
	 * @param name カテゴリ名
	 */
	public Category(String name) {
		this.name = name;
	}

	// ゲッター
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
