package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VOrderDetail;

public interface VOrderDetalsRepository extends JpaRepository<VOrderDetail, Integer> {
	// SELECT * FROM v_orderDetails WHERE customer_id = ?
	List<VOrderDetail> findByCustomerId(int id);

}
