package com.denistiago.service;

import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {
	
	public <T> Response<T> buildResponse(T data) {
		return new Response<T>(data);
	}
	
	public <T> Response<T> buildErrorResponse() {
		return new Response<T>(ResponseCode.PROBLEM);
	}

}
