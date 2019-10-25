package com.tt.training.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.core.encoder.Encoder;

@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder encoderB() {
		return new BCryptPasswordEncoder();
	}

	public void configureSecurity(AuthenticationManagerBuilder auth) {
		try {

			BCryptPasswordEncoder encoderB = encoderB();

			auth.inMemoryAuthentication().passwordEncoder(encoderB).withUser("ali").password(encoderB.encode("1234")).roles("ADMIN")
					.and().withUser("veli").password(encoderB.encode("1234")).roles("USER");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Autowired
	public void configureDynamicSecurity(AuthenticationManagerBuilder auth) {
		try {

			BCryptPasswordEncoder encoderB = encoderB();
			MyUserDetailService userDetailsService = new MyUserDetailService(encoderB);
			auth.userDetailsService(userDetailsService).passwordEncoder(encoderB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
