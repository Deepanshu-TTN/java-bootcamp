package com.ttn.springsecurity.config;

import com.ttn.springsecurity.filter.CouponFilter;
import com.ttn.springsecurity.filter.JWTFilter;
import com.ttn.springsecurity.filter.MySecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    JWTFilter jwtFilter;

    @Bean
    BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain couponFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults())
                .securityMatcher("/coupons/**")
                .authorizeHttpRequests(authorize->{
                    authorize.requestMatchers(HttpMethod.GET, "/coupons/**").hasAnyAuthority("USER", "ADMIN")
                            .requestMatchers(HttpMethod.POST, "/coupons").hasAnyAuthority("ADMIN", "MODERATOR");
                        }
                ).csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new CouponFilter(), JWTFilter.class);

        return httpSecurity.build();
    }

    @Bean
    SecurityFilterChain jwtFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/jwt/**")
                .authorizeHttpRequests(autherize -> {
                    autherize.requestMatchers(HttpMethod.POST, "/jwt/obtain-token").permitAll();
                }).csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->

                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(autherize -> {
                    autherize.requestMatchers(HttpMethod.POST, "/users").permitAll()
                            .anyRequest().denyAll();
                }).csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager manager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
