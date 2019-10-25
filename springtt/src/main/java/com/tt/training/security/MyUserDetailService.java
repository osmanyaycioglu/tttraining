package com.tt.training.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserDetailService implements UserDetailsService{
	
	private BCryptPasswordEncoder enc;

	public MyUserDetailService(BCryptPasswordEncoder encoderB) {
		this.enc = encoderB;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails build = User
				.builder()
				.username(username)
				.password(enc.encode("1234"))
				.roles("USER")
				.build();
		return build;
	}

}
