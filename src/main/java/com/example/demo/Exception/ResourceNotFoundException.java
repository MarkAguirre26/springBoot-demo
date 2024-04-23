package com.example.demo.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */

	@Serial
	private static final long serialVersionUID = 1L;
	private final String resourceName;
	private final String fieldName;
	private final Object fieldValue;
	
	public ResourceNotFoundException(Class<?> clazz,String resourceName, String fieldName, Object fieldValue) {
		String message =String.format("%s record not found with %s : '%s'", resourceName, fieldName, fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		LoggerUtil.logError(clazz,message,null);
	}

}
