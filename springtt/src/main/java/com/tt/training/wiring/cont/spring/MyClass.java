package com.tt.training.wiring.cont.spring;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.tt.training.model.Employee;

public class MyClass {

	@Autowired
	private IFormat formatter;

	public String formatEmployee(Employee emp) {
		return formatter.format(emp);
	}
}
