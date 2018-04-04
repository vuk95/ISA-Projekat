package rs.ac.uns.ftn.informatika.Cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import rs.ac.uns.ftn.informatika.Cinema.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/HomePage.html").permitAll()
			.antMatchers("/registration").permitAll()
			.antMatchers("/profile/**").authenticated()
			.antMatchers("/fanzone/getRekviziti").hasAuthority("FAN_ZONE")
			.antMatchers("/fanzone/getRekvizitiObican").hasAuthority("REGULAR")
			.and()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")			
			.defaultSuccessUrl("/HomePage.html")			//dok se ne promeni
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout=true")
			.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}
