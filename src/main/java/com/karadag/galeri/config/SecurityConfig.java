package com.karadag.galeri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final AuthenticationProvider provider;

    private final AuthenticationEntryPoint point;

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(x -> x.disable())
                .authorizeHttpRequests(auth -> auth

                        // Herkes erişebilir
                        .requestMatchers("/auth/**").permitAll()

                        // Hesap işlemleri
                        .requestMatchers(HttpMethod.GET, "/account/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/account/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/account/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/account/**")
                        .hasRole("ADMIN")

                        // Araç işlemleri
                        .requestMatchers(HttpMethod.GET, "/car/**")
                        .hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/car/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/car/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/car/**")
                        .hasRole("ADMIN")

                        // Satış işlemleri
                        .requestMatchers("/sale/**")
                        .hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/user/*/role")
                        .hasRole("ADMIN")

                        .anyRequest().authenticated())
                .authenticationProvider(provider)
                .exceptionHandling(x -> x.authenticationEntryPoint(point))
                .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(provider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}