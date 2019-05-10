package com.mehedi.travedia.config.security;

import com.mehedi.travedia.service.auth.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Spring config done");
//        http.authorizeRequests()
//                .anyRequest()
//                .hasAnyRole("ADMIN", "USER")
//                .and()
//                .authorizeRequests().antMatchers("/login**").permitAll()
//                .and()
//                .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll()
//                .and()
//                .csrf().disable();

        http.authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .and().formLogin().loginPage("/auth/login").loginProcessingUrl("/auth/login").permitAll()
                .and().logout().logoutSuccessUrl("/auth/login").permitAll()
                .and().csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }


}
