package com.codeacademy.blogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/h2/**", "/login", "/", "/public/**").permitAll()
                .antMatchers("/private/**").authenticated()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("user")
                .passwordParameter("password")
                .defaultSuccessUrl("/public/index", true)
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/public/index");

        http.csrf().ignoringAntMatchers("/h2/**");

        http.headers().frameOptions().sameOrigin();
    }

    @Override
    public void configure(WebSecurity webSecurity) {
//        webSecurity.ignoring().antMatchers("/**"); // isjungia security
        webSecurity.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//        webSecurity.ignoring().antMatchers("/error");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Custom user storage
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());

//      // JDBC user storage
//        auth.jdbcAuthentication()
//                .passwordEncoder(encoder())
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, password, TRUE as enabled FROM User WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT u.username, r.role_name FROM Role r " +
//                        " JOIN User_roles ur ON r.id = ur.role_id " +
//                        " JOIN User u ON u.id = ur.user_id " +
//                        " WHERE u.username = ?");

//
        // In memory user storage
//                auth
//                .inMemoryAuthentication()
//                .withUser("user")
//                .password(encoder().encode("user"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(encoder().encode("admin"))
//                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

