package com.airfrance.testfirassahli.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig to permit all requests on our application
 *
 * @author firas.sahli
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity http) throws Exception{
        http.ignoring().antMatchers("/**");
    }
}
