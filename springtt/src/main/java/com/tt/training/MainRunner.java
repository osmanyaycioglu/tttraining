package com.tt.training;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainRunner {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringttApplication.class, args);
		
//		SpringttApplication bean = applicationContext.getBean(SpringttApplication.class);
//		bean.getEmployee().setAge(50);
		
//		SpringttApplication application = new SpringttApplication();
//		application.employee.setAge(50);
	}

}
