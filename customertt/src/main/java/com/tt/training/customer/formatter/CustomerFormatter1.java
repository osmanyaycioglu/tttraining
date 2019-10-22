package com.tt.training.customer.formatter;

import com.tt.training.customer.model.Customer;

public class CustomerFormatter1 implements ICustomerFormatter {

	@Override
	public String formatCustomer(Customer customer) {
		return "Sayın " + customer.getName() + " " 
					+ customer.getSurname() 
					+ "\n" 
					+ "İş " 
					+ customer.getJob();
	}

}
