package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryAdminController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
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
