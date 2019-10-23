package com.tt.training;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyMethodWirring {

	private MyWireTestUseClass myWireTestUseClass;

	@Autowired
	public void method(MyWireTestUseClass myWireTestUseClassParam) {
		myWireTestUseClass = myWireTestUseClassParam;
		myWireTestUseClass.setTest("Test String");
	}

}
