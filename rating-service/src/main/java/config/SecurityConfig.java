package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String baseURI = "/api/v1/ratings/";
    private static final String roleAdmin = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable()
                .authorizeRequests()
                .regexMatchers("^/api/v1/ratings\\?bookId").authenticated()
                .antMatchers(HttpMethod.GET, baseURI).permitAll()
                .antMatchers(HttpMethod.GET, baseURI + "*").permitAll()
                .antMatchers(HttpMethod.POST, baseURI).authenticated()
                .antMatchers(HttpMethod.PUT, baseURI + "*").hasRole(roleAdmin)
                .antMatchers(HttpMethod.DELETE, baseURI + "*").hasRole(roleAdmin)
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
