package com.risby.todoapp.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    Environment env;

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/actuator/info").permitAll();
                    auth.requestMatchers("/actuator/**").hasRole("DEV");
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        PasswordEncoder encoder = new StandardPasswordEncoder();
        System.out.println("{noop}"+env.getProperty("DEV_PASSWORD", "pass"));

        return new InMemoryUserDetailsManager((
                User.withUsername("dev")
                        .password("{noop}" + env.getProperty("DEV_PASSWORD", "pass"))
                        .roles("DEV")
                        .build()
                ));
    }
}
