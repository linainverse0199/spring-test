package com.example.demo.config;

import com.example.demo.services.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * This is in-memory spring "security" configuration
         */
/*        auth.inMemoryAuthentication()
                .withUser("user").password("pass").authorities("ROLE_USER")
                .and()
                .withUser("admin").password("pass").authorities("ROLE_ADMIN")
                .and().passwordEncoder(new BCryptPasswordEncoder());
        *//**
         * This is JDBC Spring security configuration
         *//*
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder());
        // LDAP based Spring security
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder()) // they passed encrypted, and in LDAP they also encrypted
                .passwordAttribute("password");
        */
        auth.userDetailsService(userDetailsService)
                // this method call is intercepted
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Define what conditions should done to pass the request
        // configure custom login page
        // enable log out
        // CORS
        // First have higher precedence than lower.
        http
                .authorizeRequests()
                .antMatchers("/giftitem", "/giftset", "/giftitem/**", "/giftset/**")
                .hasRole("USER")
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
