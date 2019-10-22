package com.tt.training.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.tt.training.Secmen;

@Component
@Secmen("üçüncü")
public class Executor3 implements IExecutor{

	@Override
	public String execute() {
		return "Executor3";
	}

}
