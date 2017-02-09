package almond.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
    abstract void configureCsrf(HttpSecurity http) throws Exception;
    
    abstract void configureHttpBasic(HttpSecurity http) throws Exception;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configureCsrf(http);
        configureHttpBasic(http);
        
        http.authorizeRequests()
            .antMatchers("/css/**", "/js/**").permitAll();
        
        http.authorizeRequests()
		        .antMatchers("/").access("hasRole('ROLE_ADMIN')")
		 	    .antMatchers("/users/login","/users/registration","/users/registration_ok").permitAll()
		 	    .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successForwardUrl("/users/loginProcess")
                .failureForwardUrl("/users/loginFail")
            .and()
                .logout()
                .logoutSuccessUrl("/users/login?logout")
            .and()
                .exceptionHandling()
                .accessDeniedPage("/exception");
    }

    @Configuration
    @EnableWebSecurity
    @Profile("local")
    static class LocalWebSecurityConfig extends WebSecurityConfig {
        private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.TestWebSecurityConfig.class);
        
        @Override
        void configureCsrf(HttpSecurity http) throws Exception {
            log.info("disable csrf local profile");
            http.csrf().disable();
        }

        @Override
        void configureHttpBasic(HttpSecurity http) throws Exception {
        }
        
        @Bean(name="passwordEncoder")
        public PasswordEncoder passwordencoder(){
        	return NoOpPasswordEncoder.getInstance();
        }
    }
    
    @Configuration
    @EnableWebSecurity
    @Profile("test")
    static class TestWebSecurityConfig extends WebSecurityConfig {
        private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.TestWebSecurityConfig.class);
        
        @Override
        void configureCsrf(HttpSecurity http) throws Exception {
            log.info("disable csrf test profile");
            http.csrf().disable();
        }

        @Override
        void configureHttpBasic(HttpSecurity http) throws Exception {
            http.httpBasic();
        }
        
        @Bean(name="passwordEncoder")
        public PasswordEncoder passwordencoder(){
        	return NoOpPasswordEncoder.getInstance();
        }
    }
    
    @Configuration
    @EnableWebSecurity
    @Profile({"production"})
    static class ProductionWebSecurityConfig extends WebSecurityConfig {
        private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.ProductionWebSecurityConfig.class);
        
        @Override
        void configureCsrf(HttpSecurity http) throws Exception {
            log.info("csrf production profile");
        }

        @Override
        void configureHttpBasic(HttpSecurity http) throws Exception {
        }
        
        @Bean(name="passwordEncoder")
        public PasswordEncoder passwordencoder(){
        	return new BCryptPasswordEncoder();
        }
    }
}
