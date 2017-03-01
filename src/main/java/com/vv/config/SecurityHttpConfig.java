package com.vv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityHttpConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override public void configure(WebSecurity web) throws Exception { web
	 * .ignoring() .antMatchers("/resources/**") .antMatchers("/assets/**"); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http .authorizeRequests() .antMatchers("/index").permitAll()
	 * .antMatchers("/pricing","/sessions/**").hasRole("ADMIN")
	 * .antMatchers("/resources/**","/signup").permitAll()
	 * .anyRequest().hasRole("USER") .and() .jee()
	 * .mappableRoles("ROLE_USER","ROLE_ADMIN"); }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/index.html", "/home.html", "/login.html", "/")
				.permitAll().anyRequest().authenticated();
	}
}