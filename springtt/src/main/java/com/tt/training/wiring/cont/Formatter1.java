package com.tt.training.wiring.cont;

import com.tt.training.model.Employee;

public class Formatter1 implements IFormat {

	@Override
	public String format(Employee emp) {
		return "Sayın : " + emp.getName() + " " + emp.getSurname();
	}

}
