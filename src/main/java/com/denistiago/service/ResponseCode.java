package com.denistiago.service;

public enum ResponseCode {	
	SUCESS("SUCESS",200),
	INVALID("INVALID ARGUMENTS",203),
	PROBLEM("PROBLEM",500);	
	
	private String description;
	private int code;
	
	private ResponseCode(String description,int code) {
		this.description = description;
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}
}
