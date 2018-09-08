package com.equipe4.GeoPatrimoine1.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.equipe4.GeoPatrimoine1.service.UserDetailsServiceImpl.UserDetailsServiceImpl;

/**
 * Configuration de la securité
 */
@EnableWebSecurity
@Configuration
//@Profile("test")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	private static final String ADMIN = "ADMIN";
	private static final String USER = "admin";
	private static final String MOT_DE_PASSE = "admin";
	
	// Permet de retourner les éléments de sécurité d'un utilisateur
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	 @SuppressWarnings("deprecation")
	 @Bean
	 public static NoOpPasswordEncoder passwordEncoder() {
	 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 }
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200/*"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	
	//}
	
	/**
	 * Defines the web based security configuration.
	 *
	 * @param http -- It allows configuring web based security for specific http requests.
	 * @throws Exception
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		
		LOGGER.debug("configure HttpSecurity IN");
//		http.cors().
//		and().csrf().disable();
		
		http.csrf().disable();
	
		http
			.formLogin()
			.successHandler(new SuccessHandler());
		
		//H2 database console runs inside a frame, So we need to disable X-Frame-Options in Spring Security.
//		http.headers().frameOptions().disable();
		
		http.authorizeRequests()
				.antMatchers("/login.html").permitAll()
				.antMatchers("/api/**").permitAll() //hasRole(ADMIN)
				.anyRequest().authenticated()
				;		
	}
	
	/**
	 * configureGlobal
	 *
	 * @param auth the AuthenticationManagerBuilder
	 */
	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) {
		
		LOGGER.debug("configureGlobal Mock");
		
		try {
			auth.inMemoryAuthentication().withUser(USER).password(MOT_DE_PASSE).roles(ADMIN);
			
			auth.authenticationProvider(new AuthenticationProvider() {
				
				@Override
				public boolean supports(Class<?> arg0) {
					return true;
				}
				
				@Override
				public Authentication authenticate(Authentication arg0) {
					return null;
				}
			});
		} catch (final Exception exception) {
			LOGGER.info("{}", exception);
			LOGGER.error("auth.inMemoryAuthentication: {}", exception.getMessage());
		}
	}
	
	/**
	 * Méthode qui gère une authentification réussie. Créé un token et un cookie
	 * et renvoie vers 
	 */
	public class SuccessHandler implements AuthenticationSuccessHandler {
		@Override
		public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
				final Authentication auth) throws IOException, ServletException {
			LOGGER.debug("SuccessHandler IN");
			try {
				LOGGER.debug("auth.Name: {}",auth);
				if (auth.isAuthenticated()) {
					final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(auth.getName());
					if (userDetails == null) {
						LOGGER.warn("Utilisateur {} n'existe pas dans la BDD ", auth.getName());
						/* On renseigne les données d'authentification */
						//Création d'un jeton d'authentification (chaine de caractères) à partir du login et password
						final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
								userDetails, "", null);
						SecurityContextHolder.getContext().setAuthentication(authenticationToken);
						response.sendRedirect("/api/patrimoineHistorique");
					}else {
						response.sendRedirect("api/patrimoineHistorique");
						
					}
				}
			} catch (final UsernameNotFoundException ex) {
				LOGGER.error("", ex);
				response.sendRedirect("/login");
			}
		}
	}
	
	
}


