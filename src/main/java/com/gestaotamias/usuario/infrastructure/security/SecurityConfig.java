package com.gestaotamias.usuario.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Crie a instância do filtro aqui, após os componentes terem sido injetados
        JwtRequestFilter jwtRequestFilter = new JwtRequestFilter(jwtUtil, userDetailsService);

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/membro/login", "/auth").permitAll()
                        .requestMatchers(HttpMethod.POST, "/membro").permitAll()
                        .requestMatchers(HttpMethod.POST, "/tipoEntrada").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/tipoEntrada", "/tipoEntrada/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/tipoEntrada", "/tipoEntrada/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/entrada").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/entrada", "/entrada/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/entrada", "/entrada/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/tipoSaida").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/tipoSaida", "/tipoSaida/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/tipoSaida", "/tipoSaida/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/saida").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/saida", "/saida/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/saida", "/saida/**").permitAll()
                        .requestMatchers(
                                "/resources/**",
                                "/static/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/favicon.ico",
                                "/error"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}