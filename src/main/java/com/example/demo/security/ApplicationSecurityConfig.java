package com.example.demo.security;

//import com.example.demo.actualClasses.AppUserService;
import com.example.demo.testedPart.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.demo.actualClasses.AppUserRole.ADMIN;

//import static com.example.demo.actualClasses.AppUserRole.ADMIN;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

//    private final AppUserService appUserService;
    private final UserServiceImpl userServiceimpl;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()

                .antMatchers("/registration").permitAll()

                .antMatchers("/products/get/**").permitAll()

                .antMatchers("/homepage/administration/**").hasAuthority(ADMIN.name())
                .antMatchers("/macbooks/add/new/macbook").hasAuthority(ADMIN.name())

                .antMatchers("macbooks/find/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/loginpage")
                .permitAll()

                .and()
                .exceptionHandling().accessDeniedPage("/logon_denied_page")
                .and().formLogin()

                .defaultSuccessUrl("/homepage",true)
                .passwordParameter("password")
                .usernameParameter("username")

                .failureUrl("/incorrect_credentials_page")

                .and()
                .rememberMe()
                .tokenValiditySeconds(3600)
                .key("somethingverysecured")
                .userDetailsService(userServiceimpl)
                .rememberMeParameter("remember-me")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/loginpage");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userServiceimpl);
        return provider;
    }
}
