package com.dcl;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
	private String messageId;

	public Message() {
		super();
	}

	public Message(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
