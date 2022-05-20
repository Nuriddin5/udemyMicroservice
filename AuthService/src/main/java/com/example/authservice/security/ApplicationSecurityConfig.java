//package com.example.authservice.security;
//
//import com.example.authservice.auth.PasswordEncoder;
//import com.example.authservice.service.ApplicationUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static com.example.authservice.entity.enums.ApplicationUserRole.ADMIN;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//    private final ApplicationUserService userService;
//
//
//    @Bean
//    public AuthenticationProvider getAuthProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder.getEncoder());
//        provider.setUserDetailsService(userService);
//        return provider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//         http
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
//                 .antMatchers(HttpMethod.POST,"/api/v1/user/register").permitAll()
//                .antMatchers("/api/admin/**").
//                hasRole(ADMIN.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
////                    .loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/user")
//                .passwordParameter("password")
//                .usernameParameter("username")
//                .and()
//                .rememberMe()
////                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
////                .key("somethingverysecured")
//                .rememberMeParameter("remember-me")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // https://docs.spring.io/spring-security/site/docs/4.2.12.RELEASE/apidocs/org/springframework/security/config/annotation/web/configurers/LogoutConfigurer.html
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID", "remember-me")
//                .logoutSuccessUrl("/login");
//
//    }
//
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder.getEncoder());
//        provider.setUserDetailsService(userService);
//        return provider;
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//}
///*
//package uz.pdp.cinema.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import uz.pdp.cinema.service.UserService;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserService userService;
//
//    @Bean
//    public PasswordEncoder getEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider getAuthProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(getEncoder());
//        provider.setUserDetailsService(userService);
//        return provider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(getAuthProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN")
//                .antMatchers("/api/admin-dashboard/**").hasRole("ADMIN")
//                .antMatchers("/api/movie-sessions", "/", "/login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/api/movie-sessions")
//                .and()
//                .oauth2Login().loginPage("/login")
//                .defaultSuccessUrl("/loginSuccess",true)
//                .and()
//                .rememberMe()
//                .and()
//                .logout()
//                .and()
//                .httpBasic();
//    }
//}
//
// */