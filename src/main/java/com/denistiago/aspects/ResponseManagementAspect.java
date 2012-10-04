package com.denistiago.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denistiago.fetcher.exception.AddressDataFetcherException;
import com.denistiago.service.Response;
import com.denistiago.service.ResponseBuilder;
import com.denistiago.service.ResponseCode;

@Aspect
@Component
public class ResponseManagementAspect {
	
	@Autowired
	private ResponseBuilder responseBuilder;
	
	@SuppressWarnings("rawtypes")
	@Around("execution(* com.denistiago.service.*.*(..))")
	public Object handleResponse(ProceedingJoinPoint pjp) throws Throwable {
		
		try { 
		 
			long start = System.currentTimeMillis();	    
			
			Object retVal = pjp.proceed();	    
			if( retVal instanceof Response ) {
				Response response = (Response) retVal;
				populateResponse(start, response);
			}
			
			return retVal;
			
		} catch(AddressDataFetcherException e) {
			return responseBuilder.buildErrorResponse();
		}
		
	}

	private void populateResponse(long start, @SuppressWarnings("rawtypes") Response response) {
		float elapsedTimeInSeconds = (System.currentTimeMillis()-start)/1000F;
		response.setResponseTime(elapsedTimeInSeconds);			
		response.setResponseCode(ResponseCode.SUCESS);
	}

	
}
