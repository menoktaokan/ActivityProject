package com.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.model.Users;
import com.app.service.IUserService;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private IUserService userService;
	private List<Users> allUsers;



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		allUsers=userService.getAllUsers();
		for (Users users : allUsers) {
			auth.inMemoryAuthentication()
			.withUser(users.getUsername())
			.password(users.getPassword())
			.roles(users.getRole())
			;
		}
//		auth.inMemoryAuthentication()
//		.withUser("user").password("a").roles("USER")
//		.and()
//		.withUser("okan").password("o").roles("USER")
//		.and()
//		.withUser("admin").password("b").roles("ADMIN");
//		
	}
		
	@Bean
	public PasswordEncoder passwordEncoder () {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/check-in").hasRole("USER")
		.and()
		.formLogin();
		
		http.logout().permitAll();
		
		http
		.authorizeRequests()
		.antMatchers("/","/act-choose","/new-user","/new-user/singup").permitAll()
		.anyRequest()
		.authenticated()
		;
		
		
		http.formLogin()
		.loginPage("/loginForm")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll();
		
		http.logout().logoutSuccessUrl("/?logout").permitAll();
		
		http.exceptionHandling()
		.accessDeniedPage("/accessDenied");
		
	}

	
}
