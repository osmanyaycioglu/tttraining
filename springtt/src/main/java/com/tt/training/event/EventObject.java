package com.tt.training.event;

import org.springframework.context.ApplicationEvent;

public class EventObject extends ApplicationEvent{
	
	public EventObject(Object source) {
		super(source);
	}

	private static final long serialVersionUID = -5418677841662619544L;
	private String eventType;
	private String eventName;
	private String eventContent;
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	@Override
	public String toString() {
		return "EventObject [eventType=" + eventType + ", eventName=" + eventName + ", eventContent=" + eventContent
				+ "]";
	}
	
	
	
	
}
