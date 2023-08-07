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
	public Product save(Product product) {
		return pdao.save(product);
	}
}
