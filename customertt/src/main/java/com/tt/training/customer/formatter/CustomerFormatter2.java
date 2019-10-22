package com.tt.training.customer.formatter;

import com.tt.training.customer.model.Customer;

public class CustomerFormatter2 implements ICustomerFormatter {

	@Override
	public String formatCustomer(Customer customer) {
		return "Dear " + customer.getName() + " " 
					+ customer.getSurname() 
					+ "\n" 
					+ "Job " 
					+ customer.getJob();
	}

}
