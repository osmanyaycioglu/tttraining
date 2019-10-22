package com.tt.training.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tt.training.customer.formatter.ICustomerFormatter;
import com.tt.training.customer.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

	@Autowired
	private ICustomerFormatter formatter;

	@GetMapping("/format/{isim}/{soyisim}/{yas}")
	public String formatCustomer(
			@PathVariable("isim") String name, 
			@PathVariable("soyisim") String sn, 
			@RequestParam("is") String job, 
			@PathVariable("yas") int age
			) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSurname(sn);
		customer.setJob(job);
		customer.setAge(age);
		return formatter.formatCustomer(customer);
	}

}
