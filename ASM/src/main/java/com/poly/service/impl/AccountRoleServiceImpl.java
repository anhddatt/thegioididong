package com.poly.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountRoleDao;
import com.poly.entity.AccountRole;
import com.poly.service.AccountRoleService;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
	@Autowired
	AccountRoleDao accRoleDao;

	@Override
	public Optional<AccountRole> findByUsername(String username) {
		return accRoleDao.findByUsername(username);
	}

	

	
	
	
		
}
