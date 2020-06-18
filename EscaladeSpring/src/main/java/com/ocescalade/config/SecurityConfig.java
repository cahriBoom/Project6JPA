package com.ocescalade.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;

	@Autowired
	public SecurityConfig(@Qualifier("userService") UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(BCryptManagerUtil.passwordencoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .and()
                .formLogin()
                .loginPage("/connexion")
                .defaultSuccessUrl("/accueil").failureUrl("/connexion?error=loginError")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/connexion.jsp")
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/modifier*/**").authenticated()
                .antMatchers("/ajout*/**").authenticated()
                .antMatchers("/supprimer*/**").authenticated()
                .anyRequest().permitAll();
    }
}