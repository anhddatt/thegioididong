package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Account;
import com.poly.entity.Product;
import com.poly.service.AccountService;
@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    @Autowired 
	AccountService accountService;
	
	@GetMapping("/list")
	public List<Account> getAccounts() {
	    return accountService.findAllAccounts();
	}

    @PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
	    Account savedAccount = accountService.save(account);
	    return ResponseEntity.ok(savedAccount);
	}
}
