package com.example.tuwaiqevent_project.config;


import com.example.tuwaiqevent_project.servies.MyAdminServies;
import com.example.tuwaiqevent_project.servies.MyUserServies;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MyUserServies myUserServies;
    private final MyAdminServies myAdminServies;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserServies).passwordEncoder(new BCryptPasswordEncoder());
        auth.userDetailsService(myAdminServies).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/register").permitAll()
                .antMatchers("/api/v1/Admin").hasAuthority("Admin")
                .antMatchers("/api/v1/User").hasAuthority("User")
                .anyRequest().authenticated()
                .and().httpBasic();

    }
}
