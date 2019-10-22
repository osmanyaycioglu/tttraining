package com.tt.training.wiring;

import org.springframework.stereotype.Component;

@Component("osman")
public class Executor1 implements IExecutor{

	@Override
	public String execute() {
		return "Executor1";
	}

}
