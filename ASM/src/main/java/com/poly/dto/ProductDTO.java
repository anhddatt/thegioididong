package com.poly.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private Integer id;
	private String name;
	private String image;
	private Float price;
	private Integer quantity;
    private String categoryName;

}
