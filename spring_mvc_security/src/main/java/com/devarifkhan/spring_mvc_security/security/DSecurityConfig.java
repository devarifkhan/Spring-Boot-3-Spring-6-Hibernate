package com.devarifkhan.spring_mvc_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}12345")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}12345")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan= User.builder()
                .username("susan")
                .password("{noop}12345")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);

    }
}
