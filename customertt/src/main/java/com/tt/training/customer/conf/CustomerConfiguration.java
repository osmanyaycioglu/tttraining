package com.tt.training.customer.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tt.training.customer.formatter.CustomerFormatter1;
import com.tt.training.customer.formatter.ICustomerFormatter;

@Configuration
public class CustomerConfiguration {

	@Bean
	public ICustomerFormatter custForm() {
		return new CustomerFormatter1();
	}
}
