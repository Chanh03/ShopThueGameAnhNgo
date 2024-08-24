package com.anhngo.shopthueaccanhngo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.cors(cors -> cors.disable());

        http.authorizeHttpRequests(auth -> {
//            auth.requestMatchers("/").permitAll();
//            auth.requestMatchers("/login").authenticated();
//            auth.requestMatchers("/admin").hasAnyRole("ADMIN", "STAFF");
//            auth.requestMatchers("/users").hasRole("ADMIN");
//            auth.requestMatchers("/products").hasAnyRole("ADMIN", "STAFF");
//            auth.requestMatchers("/categories").hasAnyRole("ADMIN", "STAFF");
//            auth.requestMatchers("/order/**").authenticated();
            auth.anyRequest().permitAll();
        });
        return http.build();
    }
}

;
