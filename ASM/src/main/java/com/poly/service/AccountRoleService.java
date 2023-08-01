package com.poly.service;

import java.util.Optional;

import com.poly.entity.AccountRole;

public interface AccountRoleService {
	Optional<AccountRole> findByUsername(String username);
}
