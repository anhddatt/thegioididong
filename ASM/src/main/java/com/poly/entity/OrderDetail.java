package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float price;
	private Integer quantity;
	@JsonIgnore

	@ManyToOne @JoinColumn(name = "productid")
	private Product product;
	@JsonIgnore

	@ManyToOne @JoinColumn(name = "orderid")
	private Order order;
	
	public OrderDetail(Order order, Product product, Integer quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
}
