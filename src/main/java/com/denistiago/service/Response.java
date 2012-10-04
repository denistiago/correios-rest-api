package com.denistiago.service;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class Response<T> {
	
	private float responseTime;
	
	private ResponseCode responseCode;
	
	@XStreamAlias("responseData")
	private T data;
	
	public Response(ResponseCode code) {
		this.responseCode = code;
	}
	
	public Response(T data) {
		this.data = data;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public float getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(float elapsedTimeInSeconds) {
		this.responseTime = elapsedTimeInSeconds;
	}

}
