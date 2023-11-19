package com.example.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf()
                .and()
                .authorizeRequests()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/saveMsg").permitAll()
                .mvcMatchers("/register").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/shop").permitAll()
                .mvcMatchers("/aboutUs").permitAll()
                .mvcMatchers("/livebids").permitAll()
                .mvcMatchers("/bids/**").authenticated()
                .mvcMatchers("/bidslist").authenticated()
                .mvcMatchers("/submit").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/dash").failureUrl("/login?error=true").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true).permitAll()
                .and().httpBasic()
                .and()
                .requestCache()
                .requestCache(new HttpSessionRequestCache()) // Enable HttpSessionRequestCache
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");;

        return http.build();
    }

}
