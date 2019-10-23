package com.tt.training;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyFieldWirring {
	
	@Autowired
	private MyWireTestUseClass myWireTestUseClass;
	
	public MyFieldWirring() {
	}
	
	@PostConstruct
	public void name() {
		myWireTestUseClass.setTest("test string");
	}
	
	@PreDestroy
	public void destroy() {
		
	}
	
}
