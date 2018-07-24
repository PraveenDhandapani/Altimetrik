package com.ecommerce.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mail {
	
	@JsonProperty("sendTo")
	private String sendTo;
	
	@JsonProperty("sendToList")
	private String[] sendToList;
	
	@JsonProperty("sendCC")
	private String sendCC;
	
	@JsonProperty("sendCClist")
	private String[] sendCClist;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("message")
	private String message;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String[] getSendToList() {
		return sendToList;
	}

	public void setSendToList(String[] sendToList) {
		this.sendToList = sendToList;
	}

	public String getSendCC() {
		return sendCC;
	}

	public void setSendCC(String sendCC) {
		this.sendCC = sendCC;
	}

	public String[] getSendCClist() {
		return sendCClist;
	}

	public void setSendCClist(String[] sendCClist) {
		this.sendCClist = sendCClist;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
