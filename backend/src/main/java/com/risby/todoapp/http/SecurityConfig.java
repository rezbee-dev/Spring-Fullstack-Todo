package com.risby.todoapp.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
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
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/actuator/info").permitAll();
                    auth.requestMatchers("/actuator/**").hasRole("DEV");
                    auth.requestMatchers("/h2-console/**").hasRole("DEV");
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/api/sample/**").permitAll();
                    auth.requestMatchers("/api/docs/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        System.out.println("{noop}"+env.getProperty("DEV_PASSWORD", "pass"));

        return new InMemoryUserDetailsManager((
                User.withUsername("dev")
                        .password("{noop}" + env.getProperty("DEV_PASSWORD", "pass"))
                        .roles("DEV")
                        .build()
                ));
    }
}
