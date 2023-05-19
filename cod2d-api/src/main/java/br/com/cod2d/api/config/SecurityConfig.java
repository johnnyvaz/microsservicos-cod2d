package br.com.cod2d.api.config;

import br.com.cod2d.api.config.security.DefaultAuthenticationEntryPointConfig;
import br.com.cod2d.api.config.security.JwtConfig;
import br.com.cod2d.api.config.security.JwtTokenAuthenticationFilterConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfig jwtConfig;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new DefaultAuthenticationEntryPointConfig())
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/actuator/health",
                        "/swagger-resources/**",
                        "/csrf/**",
                        "/webjars/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/swagger-ui/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors();

        http.addFilter(new JwtTokenAuthenticationFilterConfig(authenticationManager(), jwtConfig));

    }
}
