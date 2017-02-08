package com.rockplace.almond.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rockplace.almond.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
		//auth.inMemoryAuthentication().withUser("test2@rockplace.co.kr").password("1111").roles("ADMIN");
		 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
 } 
 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
   .antMatchers("/").access("hasRole('ROLE_ADMIN')")
   .antMatchers("/css/**","/js/**").permitAll()
   .antMatchers("/login").permitAll()
   .anyRequest().authenticated()
   .and()
    .formLogin()
    .loginPage("/login")
    .usernameParameter("username")
    .passwordParameter("password")
    .successForwardUrl("/loginProcess")
    .failureForwardUrl("/loginFail")
    .and()
    .logout().logoutSuccessUrl("/logout") 
   .and()
   .exceptionHandling().accessDeniedPage("/exception")
  .and()
    .csrf();
 }
 
 @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
}