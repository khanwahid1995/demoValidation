/**
 * 
 */
package com.example.validator.demovalidation.controllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author wahid 21-Apr-2019 1:33:26 am
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControllerAdviceClass {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public Map<String, Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		return processFieldErrors(fieldErrors);
	}

	private Map<String,Object> processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
		// Error error = new Error(HttpStatus.BAD_REQUEST.value(), "validation error");

		Map<String,Object> result= new HashMap<String, Object>();
		for (org.springframework.validation.FieldError fieldError : fieldErrors) { 
			//error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());

			result.put("errorMessage", fieldError.getDefaultMessage());
			break;
		}

		/*
		 * List<String> list = new ArrayList<String>(); list.add("list2");
		 */
		return result;
	}

	static class Error {
		private final int status;
		private final String message;
		private List<FieldError> fieldErrors = new ArrayList<>();

		Error(int status, String message) {
			this.status = status;
			this.message = message;
		}

		public int getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}

		public void addFieldError(String path, String message) {
			FieldError error = new CustomFieldError("", path, message);
			fieldErrors.add(error);
		}

		public List<FieldError> getFieldErrors() {
			return fieldErrors;
		}
	}

	@AllArgsConstructor
	@ToString
	public class fieldError1 {
		private String key;
		private String errorMessage;

	}
}
