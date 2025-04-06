package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ItemRepository;

@Controller
public class ItemAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ItemRepository itemRepository;

	@PostMapping("/admin/items/add")
	public String store(
			@RequestParam(defaultValue = "0") int categoryId,
			@RequestParam String name,
			@RequestParam (defaultValue = "0") int  price,
			Model model) {
		// リクエストパラメータをもとに登録する商品をインスタンス化
		Item item = new Item(categoryId, name, price);
		// 商品インスタンスをitemsテーブルに登録
		itemRepository.save(item);
		// 画面遷移
		return "redirect:/admin/items";
	}
	
	/**
	 * 新規商品登録画面を表示する
	 * @return 新規商品登録画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/items/add")
	public String create(Model model) {
		// カテゴリセレクトボックス用のカテゴリリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		
		// 遷移先画面に引き継ぐために取得したリストをスコープに登録
		model.addAttribute("categories", categoryList);
		
		// 画面遷移
		return "admin/addItem";
	}
	
	/**
	 * 管理者用商品一覧画面を表示する
	 * @return 管理者用商品一覧画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/items")
	public String index(
			@RequestParam(defaultValue = "0") int categoryId,
			Model model) {
		
		// カテゴリリンク用のカテゴリリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		// 商品一覧用の商品リストを取得：categoryIdパラメータによって処理を分岐
		List<Item> itemList = null;
		if (categoryId > 0) {
			// categoryIdパラメータが送信された場合
			itemList = itemRepository.findByCategoryId(categoryId);
		} else {
			// categoryIdパラメータが送信されていない場合
			itemList = itemRepository.findAll();
		}
		
		// 遷移先画面に引き継ぐために取得したリストをスコープに登録
		model.addAttribute("categories", categoryList);
		model.addAttribute("items", itemList);
		
		// 画面遷移
		return "admin/items";
	}
}
