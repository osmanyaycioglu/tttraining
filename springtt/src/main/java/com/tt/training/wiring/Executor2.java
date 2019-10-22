package com.tt.training.wiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("ali")
public class Executor2 implements IExecutor{

	@Override
	public String execute() {
		return "Executor2";
	}

}
