package com.tt.training.wiring.cont.spring;

import com.tt.training.Employee;

public class Formatter1 implements IFormat {

	@Override
	public String format(Employee emp) {
		return "Sayın : " + emp.getName() + " " + emp.getSurname();
	}

}
