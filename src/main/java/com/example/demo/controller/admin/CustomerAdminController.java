package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;

@Controller
public class CustomerAdminController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository detailRepository;
	
	@GetMapping("/admin/customers/{id}/orders")
	public String orders(
			@PathVariable int id,
			Model model) {
		// パスパラメータをもとに対象顧客をcustomersテーブルから取得
		Customer target = customerRepository.findById(id).get();
		// 顧客の注文リストを取得
		List<Order> orderList = orderRepository.findByCustomerId(id);
		// 注文リストに紐づく注文明細リストを取得
		List<OrderDetail> detailList = new ArrayList<OrderDetail>();
		for (Order order : orderList) {
			detailList.addAll(detailRepository.findByOrderId(order.getId()));
		}
		
		// 遷移先画面に引き継ぐために取得したインスタンスとリストをスコープに登録
		model.addAttribute("customer", target);
		model.addAttribute("orders", orderList);
		model.addAttribute("orderDetails", detailList);
		
		// 画面遷移
		return "admin/customerDetail";
	}
	
	/**
	 * 顧客一覧画面を表示する
	 * @return 顧客一覧画面のThymeleafテンプレート名
	 */
	@GetMapping("/admin/customers")
	public String index(Model model) {
		// 顧客一覧用の顧客リストを取得
		List<Customer> customerList = customerRepository.findAll();
		// 遷移先画面に引き継ぐために取得したリストをスコープに登録
		model.addAttribute("customers", customerList);
	// 画面遷移
		return "admin/customers";
	}
}
