/**
 * 
 */
package com.example.validator.demovalidation.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validator.demovalidation.model.UserDTO;

/**
 * @author wahid
 * 21-Apr-2019 1:07:42 am
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@PostMapping("/controller1")
	public ResponseEntity<Object> testController1(@RequestBody @Valid UserDTO user){
		System.out.println(user);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
