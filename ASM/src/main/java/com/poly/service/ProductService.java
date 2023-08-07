package com.poly.service;

import java.util.List;

import org.hibernate.sql.Delete;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;

public interface ProductService {
	List<Product> findAll();

	Product findById(Integer id);
	
	List<ProductDTO> findAllProWithCate();
	
    Product save(ProductDTO productDTO);
    
    void delete(Integer id);
    
    Product save(Product product);
    
    ProductDTO findByIdProDto(Integer id);
}
