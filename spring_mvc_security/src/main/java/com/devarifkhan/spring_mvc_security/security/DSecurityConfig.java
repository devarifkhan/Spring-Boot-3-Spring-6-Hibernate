package com.devarifkhan.spring_mvc_security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username,password,enabled from users where username=?"
        );

        // define query to retrieve roles for a user
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }






    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer ->
                        configurer.requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated()

        )
                .formLogin(
                        form ->
                                form.loginPage("/showMyLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                ).logout(
                        LogoutConfigurer::permitAll
                )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied")
                        );

        return http.build();

    }



//        @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john= User.builder()
//                .username("john")
//                .password("{noop}12345")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails mary= User.builder()
//                .username("mary")
//                .password("{noop}12345")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails susan= User.builder()
//                .username("susan")
//                .password("{noop}12345")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,susan);
//
//    }
}
