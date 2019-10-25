package com.tt.training.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tt.training.event.EventObject;
import com.tt.training.wiring.Executor1;
import com.tt.training.wiring.Executor2;
import com.tt.training.wiring.IExecutor;

@Profile("live")
@Configuration
public class ConfLive {
	
	@Bean
	public IExecutor executorTest() {
		return new Executor1();
	}
}
