package com.webnovelscrossroads.config.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/users**").hasRole("ADMIN")
				.antMatchers("/users/**").hasRole("ADMIN")
				.antMatchers("/account**").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/login.html") 
				.failureUrl("/login.html?failed=true")
				.defaultSuccessUrl("/")
				.and()
			.logout() 
				.logoutUrl("/logout")
				.logoutSuccessUrl("/");
	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {	
		auth
			.jdbcAuthentication().passwordEncoder(passwordEncoder())
				.dataSource(dataSource)
				.authoritiesByUsernameQuery("select user.name, role.name from user"
						+ " join user_role on user.id = user_role.users_id"
						+ " join role on user_role.roles_id = role.id"
						+ " where user.name = ? ")
				.usersByUsernameQuery("select name, password, enabled from user"
						+ " where name = ?");
					
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
