package com.onlinebookstore.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer statusCode ;
	private String status;
	private String statusMessage;
	private Object response;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
