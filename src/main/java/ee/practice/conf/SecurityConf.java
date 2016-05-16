package ee.practice.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Created by Andrei Nikulin (KEMIT)
 * on 5/13/2016.
 *
 * The example is derived from
 * https://justinrodenbostel.com/2014/05/30/part-5-integrating-spring-security-with-spring-boot-web/
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConf extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // No security for static components and login form
    http
        .authorizeRequests()
        .antMatchers("/bower_components/**", "/login**")
        .permitAll();
    // Login form configuration
    http
        .formLogin().failureUrl("/login?error")
        .defaultSuccessUrl("/books")
        .loginPage("/login")
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?loggedOut")
        .permitAll();
    // All other requests must be authorized
    http
        .authorizeRequests()
        .anyRequest()
        .authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
  }


}
