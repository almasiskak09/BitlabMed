package com.medProject.bitlabMed.config;

import com.medProject.bitlabMed.services.UserService;
import com.medProject.bitlabMed.services.implementation.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoder());

        http.authorizeRequests(
                        authorize -> authorize
                                .requestMatchers("/sign-in", "/entering", "/sign-up", "/registration").anonymous()
                                .requestMatchers("/add-to-cart","/delete-from-cart").permitAll()
                                .requestMatchers("/sign-out", "/change-password", "/save-password").authenticated()
                                .requestMatchers("/profile").hasAuthority("ROLE_USER")
                                .requestMatchers("/profile-doctor").hasAuthority("ROLE_DOCTOR")
                                .requestMatchers("/profile-manager").hasAuthority("ROLE_MANAGER")
                                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                                .requestMatchers("/home", "/doctors", "/analyses", "/diagnostic","/cart","/app-doctor/**").permitAll()
                                .requestMatchers("/doctor/**","/users/**","/analyzes/**","/analyze-category/**","/diagnostic/**","/diagnostic-category/**","/addApplication","/application-analyzes/**","/appointments/**","/week-schedule","/addAppointmentDoctor","/deleteAppointment").permitAll()
                                .anyRequest().hasAuthority("ROLE_ADMIN"))
                .formLogin(
                        login -> login
                                .loginProcessingUrl("/enter")
                                .defaultSuccessUrl("/home", true) // По умолчанию на /home
                                .loginPage("/sign-in")
                                .failureUrl("/sign-in?error")
                                .usernameParameter("email")
                                .passwordParameter("password")
                )
                .logout(
                        logout -> logout
                                .logoutSuccessUrl("/sign-in?logout")
                                .logoutUrl("/sign-out")
                )
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}