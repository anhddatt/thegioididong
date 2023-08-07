package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO cateDao;

	@Override
	public List<Category> findAllCategory() {
		return cateDao.findAll();
	}

	@Override
	public Category findByName(String category) {
		return cateDao.findByName(category);
	}

	@Override
	public Category findById(String id) {
		return cateDao.findById(id).get();
	}



	
}
