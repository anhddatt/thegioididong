package com.poly.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.AccountRole;

public interface AccountRoleDao extends JpaRepository<AccountRole, Integer> {
	@Query("SELECT ar FROM AccountRole ar WHERE ar.accounts.username = :username")
	Optional<AccountRole> findByUsername(String username);
}
