package com.tt.training.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<EventObject> {

	@Override
	public void onApplicationEvent(EventObject event) {
		System.out.println(event);
	}

}
