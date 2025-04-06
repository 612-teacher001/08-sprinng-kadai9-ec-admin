package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping("/admin/categories/{id}/edit")
	public String store(
			@PathVariable int id,
			@RequestParam String name) {
		// パスパラメータとリクエストパラメータより更新するカテゴリをインスタンス化
		Category target = new Category(id, name);
		// カテゴリインスタンスをcategoriesテーブルに登録
		categoryRepository.save(target);
		// 画面遷移
		return "redirect:/admin/categories";
	}
	
	/**
	 * カテゴリ更新画面を表示する
	 * @param id    更新するカテゴリのカテゴリID
	 * @param model 遷移先画面に引き継ぐデータを登録するスコープ
	 * @return カテゴリ更新画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/categories/{id}/edit")
	public String edit(
			@PathVariable int id,
			Model model) {
		// パスパラメータをもとにcategoriesテーブルからカテゴリを取得
		Category target = categoryRepository.findById(id).get();
		// 遷移先画面に引き継ぐために取得したリストをスコープに登録
		model.addAttribute("category", target);
		// 画面遷移
		return "admin/editCategory";
	}
	
	/**
	 * カテゴリを新規登録する
	 * @param name カテゴリ名
	 * @return カテゴリ一覧画面のThymeleafテンプレート名
	 */
	@PostMapping("/admin/categories/add")
	public String store(@RequestParam String name) {
		// リクエストパラメータをもとに登録するカテゴリをインスタンス化
		Category target = new Category(name);
		// カテゴリインスタンスをcategoriesテーブルに登録
		categoryRepository.save(target);
		// 画面遷移
		return "redirect:/admin/categories";
	}
	
	/**
	 * カテゴリ登録画面を表示する
	 * @return カテゴリ登録画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/categories/add")
	public String create() {
		// 画面遷移
		return "admin/addCategory";
	}
	
	/**
	 * カテゴリ一覧画面を表示する
	 * @param model 遷移先画面に引き継ぐデータを登録するスコープ
	 * @return カテゴリ一覧画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/categories")
	public String index(Model model) {
		// カテゴリ一覧用のカテゴリリストを取得
		List<Category> categoryList = categoryRepository.findAll();
		// 遷移先画面に引き継ぐために取得したリストをスコープに登録
		model.addAttribute("categories", categoryList);
		// 画面遷移
		return "/admin/categories";
	}
}
