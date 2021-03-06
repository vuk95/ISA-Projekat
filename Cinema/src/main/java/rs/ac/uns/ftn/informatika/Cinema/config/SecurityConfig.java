package rs.ac.uns.ftn.informatika.Cinema.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import rs.ac.uns.ftn.informatika.Cinema.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/HomePage.html").permitAll()
			.antMatchers("/registration").permitAll()
			.antMatchers("/homepage").hasAuthority("REGULAR")
			.antMatchers("/profile/**").authenticated()
			.antMatchers("/fanzone/profile/**").hasAuthority("FAN_ZONE")
			.antMatchers("/fanzone/getRekviziti/**").hasAuthority("FAN_ZONE")
			.antMatchers("/fanzone/getRekvizitiObican/**").hasAuthority("REGULAR")
			.antMatchers("/fzrekvizit/**").hasAuthority("FAN_ZONE")
			.antMatchers("/fzoglas/**").hasAuthority("REGULAR")
			.antMatchers("/fanzone/getOglasi/**").hasAuthority("REGULAR")
			.antMatchers("/fanzone/getOglasiAdmin/**").hasAuthority("FAN_ZONE")
			.antMatchers("/cinematheatre/profile/**").hasAuthority("CINEMA_THEATRE")
			//.antMatchers("/cinematheatre/getCinema/**").hasAuthority("CINEMA_THEATRE")
			//.antMatchers("/cinematheatre/getTheatre/**").hasAuthority("CINEMA_THEATRE")
			//.antMatchers("/cinematheatre/getProjekcije/**").hasAuthority("CINEMA_THEATRE")
			//.antMatchers("/cinematheatre/getPredstave/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/updatePredstave/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/updateProjekcije/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/updateCinema/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/updateTheatre/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/deleteProjekcije/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/deletePredstave/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/getReports/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinemaGraphic.html").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/performanceGraphic.html").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/deleteTheatreTicket/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/deleteCinemaTicket/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/cinemaTicketsReserve/**").hasAuthority("CINEMA_THEATRE")
			.antMatchers("/cinematheatre/theatreTicketsReserve/**").hasAuthority("CINEMA_THEATRE")
			
		

			.antMatchers("/systemAdmin/**").hasAuthority("SYSTEM")
			.and()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.successHandler(successHandler)
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
