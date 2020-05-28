package com_kim.config.auth;

import com_kim.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//security関連処理
@RequiredArgsConstructor
@EnableWebSecurity //spring security activate
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //h2-consoleを使う為のoptionをdisableする
        //authorizeRequests: url別権限管理の為
        http.csrf().disable().headers().frameOptions().disable()
                .and().authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOauth2UserService);
    }
}
