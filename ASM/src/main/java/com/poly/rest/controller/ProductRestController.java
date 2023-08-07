package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dto.ProductDTO;
import com.poly.entity.Product;
import com.poly.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

	@Autowired 
	ProductService productService;
	
	@GetMapping("/list")
	public List<Product> getAllProducts() {
	    return productService.findAll();
	}
	@GetMapping("/prodwithcate")
	public List<ProductDTO> getAllProdwithCate() {
	    return productService.findAllProWithCate();
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
	    Product savedProduct = productService.save(productDTO);
	    return ResponseEntity.ok(savedProduct);
	}
	
	@PutMapping("{id}")
	public Product updateProduct(@PathVariable("id") Integer id,@RequestBody ProductDTO productDTO) {
	   return productService.save(productDTO);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
	
	
	@GetMapping("{id}")
	public ProductDTO getOne(@PathVariable("id") Integer id) {
		return productService.findByIdProDto(id);
	}
	
	
}
 