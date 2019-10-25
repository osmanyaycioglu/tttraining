package com.tt.training.rest;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.Metric;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tt.training.db.IEmployeeDAO;
import com.tt.training.model.Employee;
import com.tt.training.wiring.IExecutor;

import io.micrometer.core.annotation.Timed;

@RestController
public class MyFirstRest {

	@Autowired
	private IEmployeeDAO empDAO;
	
	@Qualifier("ali")
	@Autowired
	private IExecutor executor;
	
	@Timed(value = "my.metrics.rest.test")
	@GetMapping(path = "/test")
	@PreAuthorize("hasRole('USER')")
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
	
	@PostMapping(path = "/hello5")
	public Employee hello5(@Validated @RequestBody Employee employee) {
		empDAO.save(employee);
		employee.setName(employee.getName() + "Return");
		return employee;
	}
	
	@ResponseStatus(code = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "Error oluştu";
	}
	
	@PostMapping(path = "/hello6")
	public ResponseEntity<?> hello6(@RequestBody Employee employee) {
		if (employee.getName() == null || employee.getName().isEmpty()) {
			Error error = new Error();
			error.setErrorMessage("Name boş olamaz");
			return ResponseEntity.status(900).body(error);
		}
		employee.setName(employee.getName() + "Return");
		return ResponseEntity.ok(employee);
	}
	
	public static class Error {
		private String errorMessage;

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		
	}

	@GetMapping(path = "/getEmp")
	public String getEmp(@RequestParam("isim") String name) {
		return "hello world " + name ;
	}


}
