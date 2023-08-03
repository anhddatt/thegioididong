package com.poly;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.entity.Account;
import com.poly.service.AccountService;
import com.poly.service.SessionService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccountService accountService;
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	SessionService session;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/rest/**","/**", "/assets/**","/home/**").permitAll()	
		.antMatchers(HttpMethod.POST, "/rest/products/put").permitAll(); // Tạm thời tắt bảo mật cho POST
		http .csrf().disable() .authorizeRequests() .anyRequest().permitAll(); 
		http.formLogin().loginPage("/home/login").loginProcessingUrl("/security/login")
				.defaultSuccessUrl("/security/login/success", false).failureUrl("/security/login/error");
		
		http.logout().logoutUrl("/security/logout").logoutSuccessUrl("/security/logout/success");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Account user = accountService.finById(username);
				String password = pe.encode(user.getPassword());
				String[] role = user.getAccountRoles().stream()				
						.map(accountRole -> accountRole.getRole().getName())
						.collect(Collectors.toList()).toArray(new String[0]);
				session.set("account", user);
				return User.withUsername(username).password(password).roles(role).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException("User not found");
			}
		});
}}
