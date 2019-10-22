package com.tt.training.wiring.cont;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.env.Environment;

import com.tt.training.Employee;

public class MyClass {

	private IFormat formatter ;
	private int formatterType = 0;

	public MyClass() {
		try (InputStream inputStream = new FileInputStream("./my.properties")) {
			Properties properties = new Properties();
			properties.load(inputStream);
			formatterType = Integer.parseInt(properties.getProperty("formatter.type"));
			switch (formatterType) {
			case 1:
				formatter = new Formatter1();
				break;
			case 2:
				formatter = new Formatter2();
				break;

			default:
				formatter = new Formatter1();
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String formatEmployee(Employee emp) {
		return formatter.format(emp);
	}
}
