package com.poly.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Product;


public interface ProductDAO extends JpaRepository<Product, Integer>{
	/*
	 * Product findByName(String Name);
	 * 
	 * @Query("SELECT o FROM Product o WHERE o.name LIKE ?1 or o.price LIKE ?1 or o.id LIKE ?1 or o.category.name LIKE ?1"
	 * ) Page<Product> findByKeywords(String keywords, Pageable pageable);
	 * 
	 * @Query("SELECT o FROM Product o WHERE o.id=?1") Product
	 * findProductById(Integer id);
	 * 
	 * @Query("SELECT o FROM Product o WHERE o.id = :productId") Product
	 * findProductById1(@Param("productId") Integer productId);
	 * 
	 * Optional<Product> findById(Integer id);
	 * 
	 * List<Product> findByCategoryId(String categoryId, Pageable pageable);
	 * 
	 * Page<Product> findAll(Pageable pageable);
	 * 
	 * boolean existsByName(String name);
	 * 
	 * Product findById(int id);
	 */
}
