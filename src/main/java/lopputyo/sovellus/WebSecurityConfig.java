package lopputyo.sovellus;

import org.springframework.beans.factory.annotation.Autowired;
/*import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;*/
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//for weblayer testing
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lopputyo.sovellus.web.UserDetailServiceImpl;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
*/

	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
		@Autowired
		private UserDetailServiceImpl userDetailsService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable();
			http
			.authorizeRequests().antMatchers("/login").permitAll() //vain login sivu on sallittu kaikille 
			.and()
			.authorizeRequests().anyRequest().authenticated() //muut vaatii kirjautumisen
			.and()
			.exceptionHandling().accessDeniedPage("/login") // error sivu
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/premises") //minne lähetetään
				.permitAll()
				.and()
				.logout()
					.permitAll();
		}
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
			
		}
		
		
	}
	
	


