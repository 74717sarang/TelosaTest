package com.todo.dto;

import java.time.LocalDateTime;

public class ApiResponse {

	private String message;
	private LocalDateTime timeStamp;
	
	public  ApiResponse () {
		
	}
	public ApiResponse(String message, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
}
