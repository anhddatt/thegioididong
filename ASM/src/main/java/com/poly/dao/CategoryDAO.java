package com.poly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
	Category findByName(String categoryName);

}
