package com.poly.service;

import java.util.List;
import java.util.Optional;

import com.poly.entity.Account;

public interface AccountService {
	List<Account> findAllAccounts();
	Optional<Account> findById(String username);
	Account finById(String username);
	Account save(Account account);
}
