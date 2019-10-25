package com.tt.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.google.gson.Gson;
import com.tt.training.model.Employee;
import com.tt.training.wiring.Executor1;
import com.tt.training.wiring.IExecutor;
import com.tt.training.wiring.cont.spring.MyClass;
import com.tt.training.wiring.cont.spring.Formatter1;
import com.tt.training.wiring.cont.spring.Formatter2;
import com.tt.training.wiring.cont.spring.IFormat;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication(scanBasePackages = {"com.tt.training","com.tt.development"},excludeName = "applicationEventMulticaster" )
public class SpringttApplication implements ApplicationRunner{
	
	@Autowired
	private MyClass myClass;
	

	@Autowired
	@Qualifier("ali")
	private IExecutor executor;
	
	@Autowired
	@Secmen("üçüncü")
	private IExecutor exec;
	
	@Autowired
	private IExecutor osman;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(executor.execute());
		
		System.out.println("İkinci : " + exec.execute());
		
		System.out.println("Osman : " + osman.execute());
		
		
		Employee employee = new Employee();
		employee.setAge(49);
		employee.setName("osman");
		employee.setSurname("yaycioglu");

		System.out.println(myClass.formatEmployee(employee));

	}


}
