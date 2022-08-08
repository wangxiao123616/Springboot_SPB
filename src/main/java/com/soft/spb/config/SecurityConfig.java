package com.soft.spb.config;

import com.soft.spb.Filter.UserTokenFilter;
import com.soft.spb.Hanlder.SAuthenticationHanlder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * @author nmy
 * @title: SecurityConfig
 * @date 2022-08-06 12:26
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SAuthenticationHanlder sAuthenticationHanlder;

    @Autowired
    UserTokenFilter userTokenFilter;

    @Autowired
    CorsFilter crsFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/users/login","/users/register").anonymous()
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/attentiontopic/**",
                        "/collectbar/**",
                        "/follow/**",
                        "/likepb/**",
                        "/postbarComment/**",
                        "/postbarlist/**",
                        "/topic/**",
                        "/user/**",
                        "/users/**",
                        "/userSign/**",
                        "/upload/**"
                ).permitAll()
                .anyRequest().authenticated();
        //  http.exceptionHandling().authenticationEntryPoint(sAuthenticationHanlder);
        http.addFilterBefore(userTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(crsFilter, UserTokenFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
