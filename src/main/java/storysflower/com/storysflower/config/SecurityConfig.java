package storysflower.com.storysflower.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;
import storysflower.com.storysflower.services.impls.UserDetailServiceImpl;


/**
 * Security config.
 *
 * @author ntynguyen
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }*/

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(characterEncodingFilter(), CsrfFilter.class)
                .authorizeRequests()

                    .antMatchers("/admin/user/del").hasRole("ADMIN")
                    .antMatchers("/admin/user/add").hasRole("ADMIN")
                    .antMatchers("/admin/customer/**").hasAnyRole("ADMIN","USER")
                    .antMatchers("/admin/cart/**").hasAnyRole("ADMIN","USER")
                    .antMatchers("/admin/user/**").hasAnyRole("ADMIN","USER")
                    .antMatchers("/admin/revenue/**").hasAnyRole("ADMIN","USER")
                    .antMatchers( "/api/rating/**", "/api/favourite/**", "/api/review/**")
                    .authenticated()
                    .anyRequest().permitAll()
                    .and()

                .formLogin()
                    .loginPage("/admin/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/admin/user/index")
                    .failureUrl("/admin/login?error")
                    .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                    .logoutSuccessUrl("/admin/login").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/admin/403");


    }

    private CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
