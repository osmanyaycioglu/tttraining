package com.tt.training.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private ApplicationEventMulticaster aem;

	@Override
	public void run(String... args) throws Exception {
		EventObject eventObject = new EventObject(this);
		eventObject.setEventType("TEST");
		eventObject.setEventName("MYEVENT");
		eventObject.setEventContent("Event test");
		aem.multicastEvent(eventObject);
	}

}
