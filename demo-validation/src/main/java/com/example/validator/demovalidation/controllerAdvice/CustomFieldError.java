/**
 * 
 */
package com.example.validator.demovalidation.controllerAdvice;

import org.springframework.validation.FieldError;

/**
 * @author wahid
 * 21-Apr-2019 1:48:31 am
 */
public class CustomFieldError extends FieldError {

	/**
	 * @param objectName
	 * @param field
	 * @param defaultMessage
	 */
	public CustomFieldError(String objectName, String field, String defaultMessage) {
		super(objectName, field, defaultMessage);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.FieldError#getField()
	 */
	@Override
	public String getField() {
		// TODO Auto-generated method stub
		return super.getField();
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.FieldError#toString()
	 */
	@Override
	public String toString() {
		return "success";
	}
	
	

}
