package tacs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/","/home").permitAll()
                //TODO Sirve para cuando se quiera autentificar
                //.antMatchers("/actores/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/actores/**").permitAll()
                .antMatchers("/peliculas/**").permitAll()
                .antMatchers("/movielist/**").permitAll()
                .antMatchers("/usuarios/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth
        .inMemoryAuthentication()
            .withUser("admin").password("1234").roles("ADMIN");
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
    

}
