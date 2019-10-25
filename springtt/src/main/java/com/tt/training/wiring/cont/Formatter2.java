package com.tt.training.wiring.cont;

import com.tt.training.model.Employee;

public class Formatter2 implements IFormat{

	@Override
	public String format(Employee emp) {
		return "Name : " + emp.getName();
	}

}
