package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	@Query(value = "SELECT SUM(oi.total) FROM Orders oi ", nativeQuery = true)
    Double getTotal();
	
}
