package com.revature.beans;

import java.util.List;

public class Message {
	private List<String> userList;
	private String messageSubject;
	private String messageBody;
	
	public Message() {}
	
	public Message(List<String> userList, String messageSubject, String messageBody) {
		super();
		this.userList = userList;
		this.messageSubject = messageSubject;
		this.messageBody = messageBody;
	}

	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}	
}
