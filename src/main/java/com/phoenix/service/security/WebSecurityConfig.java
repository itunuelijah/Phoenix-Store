package com.phoenix.service.security;


import org.hibernate.Session;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


public class WebSecurityConfig extends WebSecurityConfigurer {
     WebSecurityConfigurerAdapter{

     }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        throws  Exception {

            http.csrf().disable()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
