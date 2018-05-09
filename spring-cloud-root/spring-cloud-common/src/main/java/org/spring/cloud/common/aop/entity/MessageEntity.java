package org.spring.cloud.common.aop.entity;

import org.spring.cloud.common.aop.annotation.MessageOperation;
import org.spring.cloud.common.aop.annotation.MessageType;

public class MessageEntity {
	
	private MessageType type;
	
	private MessageOperation operation;
	
	private String payload;

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public MessageOperation getOperation() {
		return operation;
	}

	public void setOperation(MessageOperation operation) {
		this.operation = operation;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

}
