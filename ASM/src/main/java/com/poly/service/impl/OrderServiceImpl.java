package com.poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.poly.service.OrderService;

public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderService ordService;
	
	@Override
	public Double getTotal() {
		return ordService.getTotal();
	}
	
}
