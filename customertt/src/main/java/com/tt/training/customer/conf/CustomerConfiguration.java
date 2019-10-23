package com.tt.training.customer.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tt.training.customer.formatter.CustomerFormatter1;
import com.tt.training.customer.formatter.CustomerFormatter2;
import com.tt.training.customer.formatter.ICustomerFormatter;

@Configuration
public class CustomerConfiguration {
	
	@Qualifier("old")
	@Bean
	public ICustomerFormatter custForm() {
		return new CustomerFormatter1();
	}

	@Qualifier("ext")
	@Bean
	public ICustomerFormatter custForm2() {
		return new CustomerFormatter2();
	}

}
