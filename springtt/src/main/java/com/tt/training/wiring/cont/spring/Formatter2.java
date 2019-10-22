package com.tt.training.wiring.cont.spring;

import com.tt.training.Employee;

public class Formatter2 implements IFormat{

	@Override
	public String format(Employee emp) {
		return "Name : " + emp.getName();
	}

}
