package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Accountroles")
public class AccountRole implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	Integer id;
	@ManyToOne @JoinColumn(name="username")
	Account accounts;
	@ManyToOne @JoinColumn(name="role")
	Role role;
}
     