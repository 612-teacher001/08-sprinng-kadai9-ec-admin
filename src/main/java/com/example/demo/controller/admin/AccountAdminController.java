package com.example.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountAdminController {
	
	/**
	 * クラス定数：認証情報文字列定数群
	 */
	private static final String USER_NAME = "admin";
	private static final String USER_PASSWORD = "himitu";
	
	/**
	 * ユーザ認証する
	 * @param name     ユーザ名
	 * @param password パスワード
	 * @param model    遷移先画面に引き継ぐデータを登録するスコープ
	 * @return 管理者用商品一覧画面のThymeleafテンプレート名
	 */
	@PostMapping("/admin/login")
	public String login(
			@RequestParam String name,
			@RequestParam String password,
			Model model) {
		// リクエストパラメータを認証情報文字列と比較
		String nextURL = "redirect:/admin/items";
		if (!(USER_NAME.equals(name) && USER_PASSWORD.equals(password))) {
			model.addAttribute("error", "ユーザ名とパスワードが一致しませんでした");
			nextURL = "admin/login";
		}
		// 画面遷移
		return nextURL;
	}
	
	/**
	 * 管理者ログイン画面を表示する
	 * @return 管理者ログイン画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/login")
	public String index() {
		// 画面遷移
		return "admin/login";
	}
}
