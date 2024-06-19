package com.pedro.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails jhon  = User.builder()
                .username("Jhon")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();


        UserDetails mary  = User.builder()
                .username("Mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();


        UserDetails susan  = User.builder()
                .username("Susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jhon, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT , "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/{employeeId}").hasRole("ADMIN")

        ).httpBasic(withDefaults());

        // disable CSRF
        // em geral, não é necessário para REST API que use POST, PUT, DELETE, and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
