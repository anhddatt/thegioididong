package com.poly.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String image;
	private Float price;
	private Integer quantity;

	@JsonIgnore
	@ManyToOne @JoinColumn(name = "category_id")
	private Category category;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetail;
	
	  public void setImage(String image) {
	        this.image = image;
	    }
	  public String getCategoryId() {
	        if (category != null) {
	            return category.getId();
	        }
	        return null;
	    }
	
}
