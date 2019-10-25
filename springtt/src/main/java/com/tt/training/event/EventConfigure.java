package com.tt.training.event;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Configuration
public class EventConfigure {

	@Bean
	public Executor createPool() {
		return Executors.newFixedThreadPool(5);
	}
	
	@Autowired
	public void aemCreation(ApplicationEventMulticaster aem) {
		SimpleApplicationEventMulticaster multicaster = (SimpleApplicationEventMulticaster)aem;
		multicaster.setTaskExecutor(createPool());
	}
	
	
}
