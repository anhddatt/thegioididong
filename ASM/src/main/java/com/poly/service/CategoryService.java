package com.poly.service;

import java.util.List;
import java.util.Optional;

import com.poly.entity.Category;

public interface CategoryService {
	List<Category> findAllCategory();
	
	Category findByName(String category);
	
	Category findById(String id);
}
