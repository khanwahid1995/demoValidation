/**
 * 
 */
package com.example.validator.demovalidation.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author wahid
 * 21-Apr-2019 1:12:47 am
 */

@Data
public class UserDTO {
	
	@NotNull(message="username cannot be null")
	private String userName;
	
	@NotNull(message="password cannot be null")
	private String password;
	private String email;

}
