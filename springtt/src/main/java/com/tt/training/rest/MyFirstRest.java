package com.tt.training.rest;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tt.training.Employee;
import com.tt.training.wiring.IExecutor;

@RestController
public class MyFirstRest {

	@Qualifier("ali")
	@Autowired
	private IExecutor executor;

	@GetMapping(path = "/test")
	public String hello() {
		return "hello world";
	}

	@GetMapping(path = "/execute")
	public String execute1() {
		return executor.execute();
	}

	@GetMapping(path = "/hello1/{isim}/s/{soyisim}")
	public String hello1(@PathVariable("isim") String name, @PathVariable("soyisim") String surname) {
		return "hello world " + name + " " + surname;
	}

	@GetMapping(path = "/hello2")
	public String hello2(@RequestParam("isim") String name, 
						@RequestParam("soyisim") String surname) {
		return "hello world " + name + " " + surname;
	}


	@GetMapping(path = "/hello3/age/{yas}")
	public String hello3(@RequestParam("isim") String name, 
						@RequestParam("soyisim") String surname,@PathVariable("yas") int age) {
		return "hello world " + name + " " + surname + " " + age;
	}

	@GetMapping(path = "/hello4/age/{yas}",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Employee hello4(@RequestParam("isim") String name, 
						@RequestParam("soyisim") String surname,@PathVariable("yas") int age) {
		Employee employee = new Employee();
		employee.setAge(age);
		employee.setName(name);
		employee.setSurname(surname);
		return employee;
	}

}
