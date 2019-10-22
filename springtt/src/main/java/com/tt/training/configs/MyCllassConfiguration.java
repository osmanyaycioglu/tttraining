package com.tt.training.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.tt.training.wiring.cont.spring.Formatter1;
import com.tt.training.wiring.cont.spring.Formatter2;
import com.tt.training.wiring.cont.spring.IFormat;
import com.tt.training.wiring.cont.spring.MyClass;

@Configuration
@PropertySource("classpath:my.properties")
public class MyCllassConfiguration {
	
	@Autowired
	private Environment env;

	@Bean
	public MyClass createMyClass() {
		return new MyClass();
	}
	
	@Bean
	public IFormat createFormatter() {
		int formatterType = Integer.parseInt(env.getProperty("formatter.type"));
		switch (formatterType) {
		case 1:
			return new Formatter1();
		case 2:
			return new Formatter2();

		default:
			return new Formatter1();
		}

	}

}
