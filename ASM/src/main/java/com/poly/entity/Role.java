package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="Roles")
public class Role implements Serializable {
	@Id
	String id;
	String name;
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<AccountRole> accountRoles;
}
