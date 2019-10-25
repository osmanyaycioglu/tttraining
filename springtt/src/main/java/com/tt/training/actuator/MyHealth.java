package com.tt.training.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.tt.training.model.Employee;

@Component
public class MyHealth implements HealthIndicator {

	@Override
	public Health health() {
		Employee employee = new Employee();
		employee.setName("osman");
		employee.setSurname("yay");
		return Health.down().withDetail("Error", employee). build();
	}

}
