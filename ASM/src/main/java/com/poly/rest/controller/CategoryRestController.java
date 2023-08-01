package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CategoryService;
import com.poly.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class CategoryRestController {
	@Autowired 
	CategoryService categoryService;
	
	@GetMapping("/list")
	public List<Category> getCategory() {
	    return categoryService.findAllCategory();
	}
}
