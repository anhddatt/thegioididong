package com.poly.service;

import java.util.List;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;

public interface ProductService {
	List<Product> findAll();

	Product findById(Integer id);
	
	List<ProductDTO> findAllProWithCate();
	
    Product save(Product product);

}
