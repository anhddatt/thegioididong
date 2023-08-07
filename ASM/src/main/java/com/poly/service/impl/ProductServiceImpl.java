package com.poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ProductDAO;
import com.poly.dto.ProductDTO;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CategoryService;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO pdao;
	@Autowired
	CategoryService cateService;


	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
	public List<ProductDTO> findAllProWithCate() {
		List<ProductDTO> productDTOList = new ArrayList<>();
		List<Product> productList = findAll();
		List<Category> categoryList = cateService.findAllCategory();

		for (Product product : productList) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setImage(product.getImage());
			productDTO.setPrice(product.getPrice());
			productDTO.setQuantity(product.getQuantity());

			for (Category category : categoryList) {
				if (product.getCategoryId() == category.getId()) {
					productDTO.setCategoryName(category.getName());
					break;
				}
			}

			productDTOList.add(productDTO);
		}

		return productDTOList;
	}

	@Override
	public Product save(ProductDTO productDTO) {
		 Product product = new Product();
		 	product.setId(productDTO.getId());
	        product.setName(productDTO.getName());
	        product.setImage(productDTO.getImage());
	        product.setPrice(productDTO.getPrice());
	        product.setQuantity(productDTO.getQuantity());

	        Category category = cateService.findByName(productDTO.getCategoryName());
	        if (category != null) {
	            product.setCategory(category);
	        } else {
	            throw new RuntimeException("Không tìm thấy danh mục với tên: " + productDTO.getCategoryName());
	        }

		return pdao.save(product);
	}
	
	@Override
	public void delete(Integer id) {
		pdao.deleteById(id);
		
	}

	@Override
	public Product save(Product product) {
		return pdao.save(product);
	}

	@Override
	public ProductDTO findByIdProDto(Integer id) {
	    Product product = pdao.findById(id).get();
	  
	        ProductDTO dto = new ProductDTO();
	        dto.setId(product.getId());
	        dto.setName(product.getName());
	        dto.setImage(product.getImage());
	        dto.setPrice(product.getPrice());
	        dto.setQuantity(product.getQuantity());

	        Category category = cateService.findById(product.getCategoryId());
	        if (category != null) {
	        	dto.setCategoryName(category.getName());
	        }
	        return dto;
	    
	}

	

	
}
